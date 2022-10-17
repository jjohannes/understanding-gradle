plugins {
    id("java-gradle-plugin")
}

gradlePlugin {
    plugins.create("my-java-base") {
        id = name
        implementationClass = "myproject.gradle.MyJavaBasePlugin"
    }
    plugins.create("my-java-library") {
        id = name
        implementationClass = "myproject.gradle.MyJavaLibraryPlugin"
    }
    plugins.create("my-java-application") {
        id = name
        implementationClass = "myproject.gradle.MyJavaApplicationPlugin"
    }
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))
