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
    testType.set(TestSuiteType.INTEGRATION_TEST)
    configurations[sources.implementationConfigurationName].extendsFrom(
        configurations.implementation.get()
    )
}

jacoco {
    // ...
}

tasks.test {
    useJUnitPlatform() // JUnit5
    reports {
        // ...
    }
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
