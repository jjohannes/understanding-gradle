plugins {
    id("my-java-application")
}

application {
    mainModule.set("org.example.app")
    mainClass.set("org.example.app.App")
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.20.0")

    testImplementation("org.apache.commons:commons-text:1.15.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
