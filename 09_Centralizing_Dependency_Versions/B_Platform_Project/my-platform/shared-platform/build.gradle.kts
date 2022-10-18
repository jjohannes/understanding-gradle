plugins {
    id("java-platform")
}

group = "org.example.my-app"

javaPlatform.allowDependencies()

dependencies {
    api(platform("com.fasterxml.jackson:jackson-bom:2.12.4"))
    api(platform("org.springframework.boot:spring-boot-dependencies:2.5.4"))
}

// These constraints are part of the 'spring-boot-dependencies' platform and we
// do not need to define them if we rely on that existing/published platform.
// dependencies.constraints {
//     api("org.apache.commons:commons-lang3:3.12.0")
//     api("org.slf4j:slf4j-api:1.7.32")
//     api("org.slf4j:slf4j-simple:1.7.32")
// }

// Constrains for Gradle plugins
dependencies.constraints {
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
}