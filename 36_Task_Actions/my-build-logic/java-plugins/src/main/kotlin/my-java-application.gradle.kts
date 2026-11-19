plugins {
    id("application")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.compileJava {
    actions.clear() // Remove compile action from JavaCompile task
    doFirst {
        println("Number of task actions: " + actions.size)
    }
    doLast {
        this as JavaCompile
        val javac = javaCompiler.get().executablePath.asFile.toString()
        Runtime.getRuntime().exec(arrayOf( // Add our own 'java compile' implementation
            javac, source.asPath, "-d", destinationDirectory.get().asFile.toString())).waitFor()
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
