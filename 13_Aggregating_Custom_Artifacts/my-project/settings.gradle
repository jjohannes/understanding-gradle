// Locations of Gradle plugins
pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../my-build-logic")
}

// Location of other components
dependencyResolutionManagement {
    repositories.mavenCentral()
    includeBuild("../my-other-project")
    includeBuild(".")
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")

