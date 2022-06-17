plugins {
    id("my-java-application")
}

application {
    mainClass.set("myproject.MyApplication")
}

dependencies {
    implementation("org.example.my-app:business-logic")

    runtimeOnly(libs.slf4j.simple)
}
