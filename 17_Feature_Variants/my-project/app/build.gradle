plugins {
    id("my-java-application")
}

application {
    mainClass.set("myproject.MyApplication")
}

dependencies {
    implementation("org.example.my-app:business-logic")

    implementation("org.example.my-app:data-model") {
        capabilities { requireCapability("org.example.my-app:data-model-json") }
    }
}

