plugins {
    id("java")
}

group = "org.example.my-app"

dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.9")
    implementation("com.google.errorprone:error_prone_annotations:2.9.0")
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("org.slf4j:slf4j-simple:1.7.32")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

