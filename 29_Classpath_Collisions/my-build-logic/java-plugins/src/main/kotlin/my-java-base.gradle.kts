plugins {
    id("java")
    id("org.gradlex.jvm-dependency-conflict-resolution")
}

group = "org.example.my-app"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
