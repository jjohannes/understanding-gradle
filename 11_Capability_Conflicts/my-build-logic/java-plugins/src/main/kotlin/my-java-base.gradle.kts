plugins {
    id("java")
    id("metadata-rules")
}

group = "org.example.my-app"
version = "0.1"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencies.constraints {
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("org.slf4j:slf4j-simple:2.0.17")
    implementation("io.dropwizard:dropwizard-core:5.0.0")
}

configurations.all {
    resolutionStrategy.capabilitiesResolution.withCapability("org.slf4j", "slf4j-impl") {
        select("org.slf4j:slf4j-simple:0")
        select("ch.qos.logback:logback-classic:0")
    }
}