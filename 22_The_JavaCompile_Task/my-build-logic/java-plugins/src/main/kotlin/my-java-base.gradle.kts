plugins {
    id("java")
}

group = "org.example.my-app"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.withType<JavaCompile>().configureEach {
    options.isFork = true
    // options.forkOptions.jvmArgumentProviders.add { listOf("-Xmx4g") }
    options.forkOptions.memoryMaximumSize = "4g"

    // options.forkOptions.javaHome = File("/Users/jendrik/.sdkman/candidates/java/7.0.342-zulu")
    // options.forkOptions.executable ="/Users/jendrik/.sdkman/candidates/java/7.0.342-zulu/bin/javac"
    // javaCompiler.convention(null as JavaCompiler?) // Reset toolchain for this task

    // options.release.set(8)
    // sourceCompatibility = "7"
    // targetCompatibility = "7"
}


tasks.test {
    useJUnitPlatform() // JUnit5
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

// Centralized versions
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
}
dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.9")
}
