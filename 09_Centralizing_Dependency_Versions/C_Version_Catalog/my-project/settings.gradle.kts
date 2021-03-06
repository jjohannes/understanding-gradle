pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../my-build-logic")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
    includeBuild("../my-other-project")
    includeBuild(".")
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")

enableFeaturePreview("VERSION_CATALOGS")