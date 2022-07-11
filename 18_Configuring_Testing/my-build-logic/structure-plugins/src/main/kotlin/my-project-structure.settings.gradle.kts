// Locations of Gradle plugins
pluginManagement {
    repositories.gradlePluginPortal()
}

// Location of other components
dependencyResolutionManagement {
    repositories.mavenCentral()
    rootDir.parentFile.listFiles()?.filter {
        File(it, "settings.gradle.kts").exists()
    }?.forEach {
        includeBuild(it.path)
    }
}

rootDir.listFiles()?.filter {
    File(it, "build.gradle.kts").exists()
}?.forEach {
    include(it.name)
}
