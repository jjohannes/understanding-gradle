val implementation = configurations.create("implementation")
val api = configurations.create("api")
val runtimeOnly = configurations.create("runtimeOnly")
val compileClasspath = configurations.create("compileClasspath") {
    extendsFrom(implementation, api)
}

dependencies {
    api("javax.activation:activation:1.1.1")
    implementation("commons-io:commons-io:2.6")
}

val compileJava = tasks.register<JavaCompile>("compileJava") {
    destinationDirectory.set(layout.buildDirectory.dir("classes"))
    source(layout.projectDirectory.dir("src"))
    sourceCompatibility = "11"
    targetCompatibility = "11"
    classpath = files(compileClasspath)
    doLast {
        classpath.files.forEach { println(it.path) }
    }
}

configurations.create("apiElements") {
    extendsFrom(api)
    outgoing {
        artifact(compileJava.flatMap { it.destinationDirectory })
    }
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API))
    }
}
configurations.create("runtimeElements") {
    extendsFrom(implementation, runtimeOnly,api)
    outgoing {
        artifact(compileJava.flatMap { it.destinationDirectory })
    }
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
    }
}
