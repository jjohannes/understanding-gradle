plugins {
    id("java")
    id("checkstyle")
}

val myBuildGroup = "my project build"
tasks.named<TaskReportTask>("tasks") {
    displayGroup = myBuildGroup
}

tasks.register<TaskReportTask>("tasksAll") {
    group = myBuildGroup
    description = "Show additional tasks."
    setShowDetail(true)
}

tasks.build {
    group = myBuildGroup
}
tasks.check {
    group = myBuildGroup
    description = "Runs checks (including tests)."
}

tasks.register("qualityCheck") {
    group = myBuildGroup
    description = "Runs checks (excluding tests)."
    dependsOn(tasks.classes, tasks.checkstyleMain)
    dependsOn(tasks.testClasses, tasks.checkstyleTest)
}

// Hide lifecycle tasks from base plugin we have no use for
tasks.buildDependents { group = "" }
tasks.buildNeeded { group = "" }

tasks.register("lifecycleTasks") {
    group = "help"
    description = "Displays the Lifecycle Tasks of project ':${project.name}'"
    doLast {
        println()
        println("------------------------------------------------------------")
        println("Lifecycle Tasks runnable from project ':${project.name}'")
        println("------------------------------------------------------------")
        println()
        tasks.filter { it.actions.isEmpty() && !it.group.isNullOrEmpty() }.forEach {
            println("${it.name} - ${it.description}")
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
