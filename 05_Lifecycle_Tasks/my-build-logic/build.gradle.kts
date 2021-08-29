tasks.register("checkAll") {
    dependsOn(subprojects.map { ":${it.name}:check" })
}
