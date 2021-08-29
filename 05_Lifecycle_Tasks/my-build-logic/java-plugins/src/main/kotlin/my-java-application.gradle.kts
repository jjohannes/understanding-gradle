plugins {
    id("my-java-base")
    id("application")
}

val myBuildGroup = "my project build"

tasks.named("run") {
    group = myBuildGroup
}