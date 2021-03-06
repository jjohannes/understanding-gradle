tasks.register("allDependencies") {
    group = "My project build"
    description = "Run ':allDependencies --write-locks' to update all the dependency lock files"
    // Resolve dependencies of all subprojects of 'this build'
    dependsOn(subprojects.map { ":${it.name}:dependencies" })
    // Resolve dependencies of all subprojects of included builds that are not 'this build' or the 'build-logic build'
    dependsOn(gradle.includedBuilds.filter {
        it.name !in listOf(project.name, "my-build-logic")
    }.map { it.task(":allDependencies") })
}
