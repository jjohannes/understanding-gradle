package myproject.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.initialization.Settings;
import org.gradle.api.initialization.resolve.DependencyResolutionManagement;
import org.gradle.plugin.management.PluginManagementSpec;

import java.io.File;

abstract public class MyProjectStructureSettingsPlugin implements Plugin<Settings> {

    @Override
    public void apply(Settings settings) {
        PluginManagementSpec pluginManagement = settings.getPluginManagement();
        DependencyResolutionManagement dependencyResolutionManagement = settings.getDependencyResolutionManagement();
        File rootDir = settings.getRootDir();


        // Locations of Gradle plugins
        pluginManagement.getRepositories().gradlePluginPortal();

        // Location of other components
        dependencyResolutionManagement.getRepositories().mavenCentral();
        for (File folder: rootDir.getParentFile().listFiles()) {
            if (new File(folder, "settings.gradle").exists()) {
                settings.includeBuild(folder.getPath());
            }
        }

        for (File folder: rootDir.listFiles()) {
            if (new File(folder, "build.gradle").exists()) {
                settings.include(folder.getName());
            }
        }
    }
}
