plugins {
    id("java")
    id("org.gradlex.java-ecosystem-capabilities")
}

group = "org.example.my-app"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}
