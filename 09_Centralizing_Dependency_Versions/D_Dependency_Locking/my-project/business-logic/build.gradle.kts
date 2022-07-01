plugins {
    id("my-java-library")
}

dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation("org.slf4j:slf4j-api")

    implementation("org.example.my-app:shared-utils") // local component

    api("org.example.my-app:data-model") // alternative: project(":data-model")
}
