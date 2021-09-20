tasks.register("allDependencies") {
    group = "My project build"
    description = "Run ':allDependencies --write-locks' to update all the dependency lock files"
    dependsOn(subprojects.map { ":${it.name}:dependencies" })
}