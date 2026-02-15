plugins {
    id("java")
    id("jacoco")
}

group = "org.example.my-app"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

testing.suites.register<JvmTestSuite>("integrationTest") {
    configurations[sources.implementationConfigurationName].extendsFrom(
        configurations.implementation.get()
    )
}

jacoco {
    // ...
}

tasks.test {
    useJUnitPlatform { // JUnit5
        excludeTags("slow")
    }
    reports {
        // ...
    }
}

val testSlow = tasks.register<Test>("testSlow") {
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
    useJUnitPlatform {
        includeTags("slow")
    }
}

// Add results of additional test task to 'testResultsElements' to be picked up in report aggregation
configurations.testResultsElementsForTest {
    outgoing.artifact(testSlow.map { it.binaryResultsDirectory })
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Centralized versions
dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.3"))
}
dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.20.0")
}
