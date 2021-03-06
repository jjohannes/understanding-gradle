plugins {
    id("java")
    id("metadata-rules")
}

group = "org.example.my-app"
version = "0.1"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

dependencies.constraints {
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("io.dropwizard:dropwizard-core:2.0.25")
}

configurations.all {
    resolutionStrategy.capabilitiesResolution.withCapability("org.slf4j", "slf4j-impl") {
        select("org.slf4j:slf4j-simple:0")
        select("ch.qos.logback:logback-classic:0")
    }
}