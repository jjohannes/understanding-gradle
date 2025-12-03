package myproject.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.plugins.PluginContainer;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.api.tasks.testing.Test;
import org.gradle.jvm.toolchain.JavaLanguageVersion;
import org.gradle.testing.base.TestingExtension;

abstract public class MyJavaBasePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        ProjectLayout layout = project.getLayout();
        ExtensionContainer extensions = project.getExtensions();
        TaskContainer tasks = project.getTasks();
        DependencyHandler dependencies = project.getDependencies();
        ConfigurationContainer configurations = project.getConfigurations();

        plugins.apply("java");

        JavaPluginExtension java = extensions.getByType(JavaPluginExtension.class);
        SourceSetContainer sourceSets = extensions.getByType(SourceSetContainer.class);
        TestingExtension testing = extensions.getByType(TestingExtension.class);

        // java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
        java.getToolchain().getLanguageVersion().set(JavaLanguageVersion.of(17));

        project.setGroup("org.example.my-app");
        project.setVersion("1.0");

        // tasks.test { useJUnitPlatform() }
        tasks.named("test", Test.class, t -> {
            t.useJUnitPlatform();
        });

        // tasks.withType<JavaCompile>().configureEach { options.encoding = "UTF-8" }
        tasks.withType(JavaCompile.class).configureEach(t -> {
            t.getOptions().setEncoding("UTF-8");
        });

        // dependencies.constraints { implementation("org.apache.commons:commons-lang3:3.20.0") }
        dependencies.getConstraints().add("implementation", "org.apache.commons:commons-lang3:3.20.0");
        // JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME
    }
}
