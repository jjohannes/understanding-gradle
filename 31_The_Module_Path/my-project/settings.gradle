// Locations of Gradle plugins
pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../my-build-logic")
}

// Location of other components
dependencyResolutionManagement {
    repositories.mavenCentral()
}

includeBuild(".") // https://github.com/gradle/gradle/issues/21490#issuecomment-1458887481

include("app")
include("modulea")
