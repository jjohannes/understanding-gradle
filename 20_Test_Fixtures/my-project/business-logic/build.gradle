plugins {
    id("my-java-library")
}

dependencies {
    implementation("org.apache.commons:commons-lang3")

    api("org.example.my-app:data-model") // alternative: project(":data-model")

    testImplementation(testFixtures("org.example.my-app:data-model")) // short notation for ↓
    // testImplementation("org.example.my-app:data-model") {
    //     capabilities { requireCapability("org.example.my-app:data-model-test-fixtures") }
    // }
}
