plugins {
    id("my-java-base")
    id("application")
    id("org.owasp.dependencycheck")
}

dependencyCheck {
    scanConfigurations = listOf(configurations.runtimeClasspath.get().name)
    autoUpdate = false
    // ...
}
