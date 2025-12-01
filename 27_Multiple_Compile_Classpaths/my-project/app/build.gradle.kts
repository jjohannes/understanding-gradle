val implementation = configurations.create("implementation")
val runtimeOnly = configurations.create("runtimeOnly")
val compileClasspath = configurations.create("compileClasspath") {
    extendsFrom(implementation)
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API))
    }
}
val runtimeClasspath = configurations.create("runtimeClasspath") {
    extendsFrom(implementation, runtimeOnly)
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
    }
}

dependencies {
    implementation(project(":module"))
    implementation("org.slf4j:slf4j-api:2.0.17")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
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

tasks.register<JavaExec>("run") {
    mainClass.set("mypackage.App")
    classpath = files(compileJava.flatMap { it.destinationDirectory }, runtimeClasspath)
    doLast {
        classpath.files.forEach { println(it.path) }
    }
}
