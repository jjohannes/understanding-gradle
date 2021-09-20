plugins {
    id("my-java-library")
}

dependencies {
    implementation(libs.commons.lang3)
    implementation(libs.slf4j.api)

    implementation("org.example.my-app:shared-utils") // local component

    api("org.example.my-app:data-model") // alternative: project(":data-model")
}
