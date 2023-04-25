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
abstract class JavaModuleTransform : TransformAction<TransformParameters.None> {

    @get:InputArtifact
    abstract val inputArtifact : Provider<FileSystemLocation>

    @get:Inject
    abstract val archiveOperations : ArchiveOperations

    override fun transform(outputs: TransformOutputs) {
        val isModule = archiveOperations.zipTree(inputArtifact).any { it.name == "module-info.class" }
        if (isModule) {
            outputs.file(inputArtifact)
        } else {
            val originalJar = inputArtifact.get().asFile
            val target = outputs.file(originalJar.nameWithoutExtension + "-module.jar")

            JarInputStream(originalJar.inputStream()).use { input ->
                JarOutputStream(target.outputStream(), input.manifest).use { output ->
                    var jarEntry = input.nextJarEntry
                    while (jarEntry != null) {
                        output.putNextEntry(jarEntry)
                        output.write(input.readAllBytes())
                        output.closeEntry()
                        jarEntry = input.nextJarEntry
                    }

                    output.putNextEntry(JarEntry("module-info.class"))
                    output.write(this::class.java.getResourceAsStream(
                        "${originalJar.nameWithoutExtension}/module-info.class")!!.readAllBytes())
                    output.closeEntry()
                }
            }
        }
    }


}