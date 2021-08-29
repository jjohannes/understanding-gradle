plugins {
    id("my-java-library")
}

dependencies {
    implementation(project(":data-model"))
    implementation("org.apache.commons:commons-lang3:3.9")
}
