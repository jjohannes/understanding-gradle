plugins {
    id("java")
}

group = "org.example.my-app"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

configurations {
    compileClasspath {
        useLatestVersionsAndLock()
    }
    runtimeClasspath {
        useLatestVersionsAndLock()
    }
    testCompileClasspath {
        useLatestVersionsAndLock()
    }
    testRuntimeClasspath {
        useLatestVersionsAndLock()
    }
}


fun Configuration.useLatestVersionsAndLock() {
    resolutionStrategy {
        eachDependency {
            if (requested.version.isNullOrEmpty()) { useVersion("latest.release") }
        }
        activateDependencyLocking()
    }
}

dependencies.components.all {
    val version = this.id.version
    if (version.contains("beta") || version.contains("alpha")) {
        // Tell Gradle to not treat versions that contain 'beta' or 'alpha' as released
        this.status = "milestone"
    }
}



