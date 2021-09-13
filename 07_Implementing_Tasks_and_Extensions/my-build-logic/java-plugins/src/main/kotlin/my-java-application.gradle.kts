import myproject.tasks.GenerateStartScript
import myproject.tasks.MyAppExtension

plugins {
    id("my-java-base")
}

val myApp = extensions.create<MyAppExtension>("myApp")

val generateStartScript = tasks.register<GenerateStartScript>("generateStartScript") {
    mainClass.convention(myApp.mainClass)
    scriptFile.set(layout.buildDirectory.file("run.sh"))
}

val packageApp = tasks.register<Zip>("packageApp") {
    from(generateStartScript)
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

