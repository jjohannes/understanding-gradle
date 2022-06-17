pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../my-build-logic")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
    includeBuild("../my-other-project")
    includeBuild("../my-platform")
    includeBuild(".")
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")
