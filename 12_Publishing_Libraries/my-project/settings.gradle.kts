// Locations of Gradle plugins
pluginManagement {
    repositories.gradlePluginPortal()
    repositories.maven("/tmp/test-repo")
    includeBuild("../my-build-logic")
}

// Location of other components
dependencyResolutionManagement {
    repositories.mavenCentral()
    repositories.maven("/tmp/test-repo")
    includeBuild("../my-other-project") // <-- remove includeBuild() to use published version
    includeBuild(".")
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")

