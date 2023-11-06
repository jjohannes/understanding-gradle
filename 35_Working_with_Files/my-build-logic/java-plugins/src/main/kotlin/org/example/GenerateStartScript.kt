package org.example;

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.internal.file.FileOperations
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.nio.file.Files
import java.nio.file.attribute.PosixFilePermission.*
import javax.inject.Inject

@CacheableTask
abstract class GenerateStartScript : DefaultTask() {

    @get:Input
    abstract val mainClass: Property<String>

    @get:OutputFile
    abstract val scriptFile: RegularFileProperty

    // @get:Inject
    // abstract val files: FileOperations

    @TaskAction
    fun generate() {
        val main = mainClass.get() // String
        val out = scriptFile.get().asFile // java.io.File
        val script = "java -cp 'libs/*:app/*' $main"

        out.writeText(script)
        Files.setPosixFilePermissions(out.toPath(), setOf(
            OWNER_READ, OWNER_WRITE, OWNER_EXECUTE,
            GROUP_READ, GROUP_EXECUTE,
            OTHERS_EXECUTE, OTHERS_READ
        ))

        // files.sync {
        //     ...
        // }
    }
}