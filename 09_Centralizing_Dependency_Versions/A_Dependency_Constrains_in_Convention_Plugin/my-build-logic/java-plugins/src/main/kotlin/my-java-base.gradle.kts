plugins {
    id("java")
}

group = "org.example.my-app"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.20.0")
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("org.slf4j:slf4j-simple:2.0.17")
}


