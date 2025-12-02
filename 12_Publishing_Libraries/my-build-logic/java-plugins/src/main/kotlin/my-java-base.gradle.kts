plugins {
    id("java")
}

group = "org.example.my-app"
version = "1.0"

dependencies.constraints {
    implementation("org.example.my-app:shared-utils:1.0")

    implementation("org.apache.commons:commons-lang3:3.20.0")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.slf4j:slf4j-simple:1.7.36")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

