import org.example.ApplicationReportTask

plugins {
    id("application")
}

tasks.named("assemble") // access existing task
tasks.register("checkAll") // register new task
tasks.withType<JavaCompile>().configureEach {  } // configure all of a certain type

layout.projectDirectory
layout.buildDirectory

providers.environmentVariable("CI").orElse("false").get().toBoolean()
providers.gradleProperty("foo") // pass to build via -Pfoo=bar
providers.systemProperty("file.encoding")

version = providers.fileContents(layout.projectDirectory.file("version.txt"))
    .asText.get()

val fileCollection: FileCollection = configurations.runtimeClasspath.get()
fileCollection.elements.map { it.first().asFile }


val main = application.mainClass.map { "$it-report.txt" }

tasks.register<ApplicationReportTask>("applicationReport") {
    classesDir.set(tasks.compileJava.flatMap { it.destinationDirectory })
    reportFile.set(layout.buildDirectory.file(main))
}
