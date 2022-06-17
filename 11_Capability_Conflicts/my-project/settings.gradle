pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../my-build-logic")
}

dependencyResolutionManagement {
    // repositories.maven { url = uri("../patched-repo") } <- for demo purpose only
    repositories.mavenCentral()
    includeBuild("../my-other-project")
    includeBuild(".")
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")
