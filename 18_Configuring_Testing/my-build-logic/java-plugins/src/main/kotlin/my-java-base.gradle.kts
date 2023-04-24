plugins {
    id("java")
}

group = "org.example.my-app"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

// === Setup without using Test Suites convenient API
tasks.test {
    useJUnitPlatform() // JUnit5
}

val integrationTest = sourceSets.create("integrationTest")

tasks.register<Test>(integrationTest.name) {
    classpath = integrationTest.runtimeClasspath
    testClassesDirs = integrationTest.output.classesDirs

    useJUnitPlatform {
        excludeTags("slow")
    }
}
// ===

// === Alternative: use Test Suites API
// testing {
//     suites.getByName<JvmTestSuite>("test") {
//         useJUnitJupiter()
//     }
//     suites.create<JvmTestSuite>("integrationTest") {
//         // useJUnitJupiter() <- default for new suites
//         dependencies {
//             // Alternatives notation for "integrationTestImplementation(...)"
//             implementation(project(path))
//             implementation("commons-io:commons-io")
//         }
//         sources {
//             // Source Set configuration
//         }
//         targets.all {
//             testTask {
//                 options {
//                     this as JUnitPlatformOptions
//                     excludeTags("slow")
//                 }
//             }
//         }
//     }
// }
// ===

tasks.register<Test>("integrationTestSlow") {
    classpath = sourceSets["integrationTest"].runtimeClasspath
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs

    useJUnitPlatform {
        includeTags("slow")
    }
}

dependencies {
    "integrationTestImplementation"(project(path)) // production code of this project
    "integrationTestImplementation"("commons-io:commons-io")
    "integrationTestImplementation"("org.junit.jupiter:junit-jupiter-api")
    "integrationTestRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}


// Centralized versions
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    "integrationTestImplementation"(platform("org.junit:junit-bom:5.8.2"))
}
dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.9")
    testImplementation("junit:junit:4.13.2")
    add("integrationTestImplementation", "commons-io:commons-io:2.11.0")
}