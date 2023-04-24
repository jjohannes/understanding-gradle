plugins {
    id("application")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
    implementation(project(":business-logic"))
}
