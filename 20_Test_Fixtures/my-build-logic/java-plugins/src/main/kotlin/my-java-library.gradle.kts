plugins {
    id("my-java-base")
    id("java-library")
    id("java-test-fixtures")
}

val test = sourceSets.test.get()
java.registerFeature(test.name) {
    usingSourceSet(test)
}

dependencies {
    testFixturesImplementation("org.junit.jupiter:junit-jupiter-api")
}
dependencies {
    testFixturesImplementation(platform("org.junit:junit-bom:6.0.2"))
}