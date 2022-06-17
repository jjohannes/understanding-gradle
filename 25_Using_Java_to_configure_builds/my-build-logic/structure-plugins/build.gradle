plugins {
    id("java-gradle-plugin")
}

gradlePlugin {
    plugins.create("my-project-structure") {
        id = name
        implementationClass = "myproject.gradle.MyProjectStructureSettingsPlugin"
    }
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))
