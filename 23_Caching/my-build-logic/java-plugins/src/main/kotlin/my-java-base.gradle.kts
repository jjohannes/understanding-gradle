plugins {
    id("java")
}

group = "org.example.my-app"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

// Centralized versions
dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.9")
}
