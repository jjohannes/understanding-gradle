package myproject.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.JavaApplication;
import org.gradle.api.plugins.PluginContainer;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.api.tasks.bundling.Zip;

abstract public class MyJavaApplicationPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        ProjectLayout layout = project.getLayout();
        ExtensionContainer extensions = project.getExtensions();
        TaskContainer tasks = project.getTasks();
        ConfigurationContainer configurations = project.getConfigurations();

        plugins.apply("application");
        plugins.apply("my-java-base");

        JavaApplication application = extensions.getByType(JavaApplication.class);
        application.getMainClass().set("myproject.MyApplication");

        MyAppExtension myApp = extensions.create("myApp", MyAppExtension.class);
        myApp.getMainClass().convention("myproject.MyApplication");

        TaskProvider<GenerateStartScript> generateStartScript =
                tasks.register("generateStartScript", GenerateStartScript.class, t -> {

            t.getMainClass().convention(myApp.getMainClass());
            t.getScriptFile().set(layout.getBuildDirectory().file("run.sh"));
        });

        TaskProvider<Zip> packageApp = tasks.register("packageApp", Zip.class, t -> {
            t.from(generateStartScript);
            t.from(tasks.named("jar"), c -> c.into("libs"));

            t.from(configurations.getByName("runtimeClasspath"), c -> c.into("libs"));
            // JavaPlugin.RUNTIME_CLASSPATH_CONFIGURATION_NAME

            t.getDestinationDirectory().set(layout.getBuildDirectory().dir("dist"));
            t.getArchiveFileName().set("myApplication.zip");
        });

        tasks.named("build", t -> {
            t.dependsOn(packageApp);
        });
    }
}
