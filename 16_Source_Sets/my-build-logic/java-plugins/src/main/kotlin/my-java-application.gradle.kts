plugins {
    id("my-java-base")
    id("application")
}

tasks.register<JavaExec>("runJava17") {
    classpath = configurations.runtimeClasspath.get() + files(tasks.jar)
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    })
    mainClass = application.mainClass
    group = "application"
}