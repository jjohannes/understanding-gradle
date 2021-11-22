plugins {
    id("java")
}

group = "org.example.my-app"
version = "1.0"

dependencies.constraints {
    implementation("org.example.my-app:shared-utils:1.0")

    implementation("org.apache.commons:commons-lang3:3.9")
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("org.slf4j:slf4j-simple:1.7.32")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

