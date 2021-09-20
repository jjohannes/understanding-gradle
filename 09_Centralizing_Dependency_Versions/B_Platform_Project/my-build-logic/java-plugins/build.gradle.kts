plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("org.example.my-app:shared-platform"))

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
}