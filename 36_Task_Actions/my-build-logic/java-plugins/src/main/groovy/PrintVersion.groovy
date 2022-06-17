import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class PrintVersion extends DefaultTask {

    @Input
    abstract Property<String> getVersion()

    @TaskAction
    void print() {
        println("Version: ${version.get()}")
    }
}
