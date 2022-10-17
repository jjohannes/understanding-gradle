package myproject.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

public abstract class GenerateStartScript extends DefaultTask {

    @Input
    public abstract Property<String> getMainClass();

    @OutputFile
    abstract RegularFileProperty getScriptFile();

    @TaskAction
    public void generate() throws IOException {
        String main = getMainClass().get();
        File out = getScriptFile().get().getAsFile();
        String script = "java -cp 'libs/*' " + main;

        Files.write(out.toPath(), Collections.singleton(script));
    }
}