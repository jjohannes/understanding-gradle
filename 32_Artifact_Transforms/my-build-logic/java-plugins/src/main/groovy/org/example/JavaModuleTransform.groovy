package org.example

import org.gradle.api.artifacts.transform.InputArtifact
import org.gradle.api.artifacts.transform.TransformAction
import org.gradle.api.artifacts.transform.TransformOutputs
import org.gradle.api.artifacts.transform.TransformParameters
import org.gradle.api.file.ArchiveOperations
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.provider.Provider
import java.util.jar.JarEntry
import java.util.jar.JarInputStream
import java.util.jar.JarOutputStream
import javax.inject.Inject

// @CacheableTransform - if transform results should also be shared via remote build cache
abstract class JavaModuleTransform implements TransformAction<TransformParameters.None> {

    @InputArtifact
    abstract Provider<FileSystemLocation> getInputArtifact()

    @Inject
    abstract ArchiveOperations getArchiveOperations()

    @Override
    void transform(TransformOutputs outputs) {
        def isModule = archiveOperations.zipTree(inputArtifact).any { it.name == "module-info.class" }
        if (isModule) {
            outputs.file(inputArtifact)
        } else {
            def originalJar = getInputArtifact().get().asFile
            def originalJarName = originalJar.name.substring(0, originalJar.name.lastIndexOf('.'))
            def target = outputs.file(originalJarName + "-module.jar")

            new JarInputStream(new FileInputStream(originalJar)).withStream { input ->
                new JarOutputStream(new FileOutputStream(target), input.manifest).withStream { output ->
                    var jarEntry = input.nextJarEntry
                    while (jarEntry != null) {
                        output.putNextEntry(jarEntry)
                        output.write(input.readAllBytes())
                        output.closeEntry()
                        jarEntry = input.nextJarEntry
                    }

                    output.putNextEntry(new JarEntry("module-info.class"))
                    output.write(this.class.getResourceAsStream(
                        "${originalJarName}/module-info.class").readAllBytes())
                    output.closeEntry()
                }
            }
        }
    }


}