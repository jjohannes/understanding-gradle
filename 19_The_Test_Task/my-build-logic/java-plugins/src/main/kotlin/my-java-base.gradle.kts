plugins {
    id("java")
}

group = "org.example.my-app"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()

    // limited by org.gradle.workers.max
    maxParallelForks = 100

    maxHeapSize = "1g" // aka -Xmx
    minHeapSize = "1g" // aka -Xms

    // jvmArgs("-XX:+HeapDumpOnOutOfMemoryError")
    jvmArgumentProviders.add(CommandLineArgumentProvider {
        listOf("-XX:+HeapDumpOnOutOfMemoryError")
    })

    systemProperty("file.encoding", "UTF-8")
    systemProperty("java.awt.headless", "true")

    options {
        this as JUnitPlatformOptions
        excludeTags("memoryHeavy")
    }

    testLogging {
        showStandardStreams = true
    }

    reports {
        html.required.set(false)
        junitXml.required.set(true)
        junitXml.outputLocation.set(layout.buildDirectory.dir("custom"))
    }
}


// centralized versions
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    constraints {
        implementation("org.apache.commons:commons-lang3:3.9")
    }
}




















