rootProject.name = "my-other-project"

pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../my-build-logic")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

include("shared-utils")
