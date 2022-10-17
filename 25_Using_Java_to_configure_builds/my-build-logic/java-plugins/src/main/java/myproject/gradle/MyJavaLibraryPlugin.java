package myproject.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.PluginContainer;

abstract public class MyJavaLibraryPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();

        plugins.apply("java-library");
        plugins.apply("my-java-base");
    }
}
