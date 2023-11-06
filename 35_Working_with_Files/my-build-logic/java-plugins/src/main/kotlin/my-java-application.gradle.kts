import org.example.GenerateStartScript

plugins {
    id("java")
}

val generateStartScript = tasks.register<GenerateStartScript>("generateStartScript") {
    mainClass = "org.example.app.App"
    scriptFile = layout.buildDirectory.file("tmp/scripts/run")
}

val installSpec = copySpec {
    from(generateStartScript)

    into("app") {
        from(tasks.jar)
    }
    into("libs") {
        from(configurations.runtimeClasspath) {
            // filter, include, exclude, ...
            rename {
                it.substring(0, it.lastIndexOf("-")) + ".jar"
            }
        }
        // from(configurations.runtimeClasspath.get().elements.map { it.map { jar -> zipTree(jar) } }) {
        //     exclude("META-INF/**")
        // }
    }
}

val packageSpec = copySpec {
    with(installSpec)

    into("meta") {
        from(layout.projectDirectory.file("version.txt"))
    }
}

tasks.register<Sync>("install") { // in special cases: <Copy> as alternative
    with(installSpec)
    destinationDir = layout.buildDirectory.dir("install").get().asFile
}

tasks.register<Zip>("package") {
    with(packageSpec)
    destinationDirectory = layout.buildDirectory.dir("dist")
}

tasks.build {
    dependsOn(tasks.named("install"))
    dependsOn(tasks.named("package"))
}
