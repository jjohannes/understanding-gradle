rootProject.name = "my-project"

pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../my-build-logic")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
    includeBuild("../my-other-project")
}

include("app")
include("business-logic")
include("data-model")
