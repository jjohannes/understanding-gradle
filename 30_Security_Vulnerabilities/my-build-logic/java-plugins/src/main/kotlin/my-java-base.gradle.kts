plugins {
    id("java")
}

group = "org.example.my-app"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

// Setup for consistent resolution with the application runtime classpath:
val applicationRuntimeClasspath = configurations.create("applicationRuntimeClasspath") {
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
    }
    withDependencies {
        add(project.dependencies.create(project(":app")))
    }
}
configurations.all {
    if (this != applicationRuntimeClasspath) {
        shouldResolveConsistentlyWith(applicationRuntimeClasspath)
    }
}
