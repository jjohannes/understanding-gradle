plugins {
    id("my-java-library")
}

dependencies {
    implementation("org.apache.commons:commons-lang3")

    api(project(":data-model"))
}
