plugins {
    id("java")
}

group = "org.example.my-app"
version = "1.0"

dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.9")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

configurations.create("sourcesElements") {
    isCanBeResolved = false
    isCanBeConsumed = true
    extendsFrom(configurations.implementation.get())
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named("java-sources"))
    }
    sourceSets.main.get().java.srcDirs.forEach {
        outgoing.artifact(it)
    }
}
