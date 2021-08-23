plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    // ...
}