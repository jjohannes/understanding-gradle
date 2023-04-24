plugins {
    id("java")
}

group = "org.example.my-app"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
    implementation(platform("org.example.my-app:shared-platform"))
}

