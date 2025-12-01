plugins {
    id("com.android.application")
}

android {
    compileSdk = 30
    defaultConfig {
        minSdk = 26
        targetSdk = 31
    }
    namespace = "myproject.android"

    sourceSets.getByName("main") {
        // get and configure an 'AndroidSourceSet'
    }
}

androidComponents {
    onVariants() { variant ->
        sourceSets.find { it.name == "debug" }?.apply {
            // get and configure an Android 'SourceProvider' (Build Type and Flavor specific)
        }
    }
}
