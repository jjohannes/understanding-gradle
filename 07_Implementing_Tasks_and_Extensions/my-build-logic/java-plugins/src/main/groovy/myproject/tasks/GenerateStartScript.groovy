package myproject.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files
import static java.nio.file.attribute.PosixFilePermission.*

@CacheableTask
abstract class GenerateStartScript extends DefaultTask {

    @Input
    abstract Property<String> getMainClass()

    @OutputFile
    abstract RegularFileProperty getScriptFile()

    @TaskAction
    def generate() {
        def main = mainClass.get() // String
        def out = scriptFile.get().asFile // java.io.File
        def script = "java -cp 'libs/*' $main"

        out.text = script
        Files.setPosixFilePermissions(out.toPath(), [
            OWNER_READ, OWNER_WRITE, OWNER_EXECUTE,
            GROUP_READ, GROUP_EXECUTE,
            OTHERS_EXECUTE, OTHERS_READ
        ] as Set)
    }
}