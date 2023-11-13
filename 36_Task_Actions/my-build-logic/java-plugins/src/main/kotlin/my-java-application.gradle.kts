plugins {
    id("application")
}

tasks.compileJava {
    actions.clear() // Remove compile action from JavaCompile task
    doFirst {
        println("Number of task actions: " + actions.size)
    }
    doLast {
        this as JavaCompile
        Runtime.getRuntime().exec( // Add our own 'java compile' implementation
            "javac ${source.asPath} -d ${destinationDirectory.get().asFile}").waitFor()
        println("Compilation finished: ${inputs.sourceFiles.asPath}")
    }
}

tasks.register<PrintVersion>("printVersion") {
    version = project.version as String
}

tasks.register("printVersionDynamic") {
    inputs.property("version", project.version)
    doLast {
        // Task action / execution time code
        println("Version: ${inputs.properties["version"]}")
    }
}
