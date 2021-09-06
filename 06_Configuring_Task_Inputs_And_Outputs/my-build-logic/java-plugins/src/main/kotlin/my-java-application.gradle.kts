plugins {
    id("my-java-base")
}

val packageApp = tasks.register<Zip>("packageApp") {
    from(layout.projectDirectory.file("run.sh"))
    from(tasks.jar) {
        into("libs")
    }
    from(configurations.runtimeClasspath) {
        into("libs")
    }

    destinationDirectory.set(layout.buildDirectory.dir("dist"))
    archiveFileName.set("myApplication.zip")
}

tasks.build {
    dependsOn(packageApp)
}

