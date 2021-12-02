plugins {
    id("my-java-base")
    id("application")
}

val sourcesPath = configurations.create("sourcesPath") {
    isCanBeResolved = true
    isCanBeConsumed = false
    extendsFrom(configurations.implementation.get())
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named("java-sources"))
    }
}

val fullJavadoc = tasks.register<Javadoc>("fullJavadoc") {
    classpath = configurations.runtimeClasspath.get()
    source = sourcesPath.incoming.artifactView { lenient(true) }.files.asFileTree
}

tasks.build {
    dependsOn(fullJavadoc)
}
