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
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencies.constraints {
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation("io.dropwizard:dropwizard-core:5.0.0")
}

configurations.all {
    resolutionStrategy.capabilitiesResolution.withCapability("org.slf4j", "slf4j-impl") {
        select("org.slf4j:slf4j-simple:0")
        select("ch.qos.logback:logback-classic:0")
    }
}