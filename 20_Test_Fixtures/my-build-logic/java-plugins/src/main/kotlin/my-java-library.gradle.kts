plugins {
    id("my-java-base")
    id("java-library")
    id("java-test-fixtures")
}

val test = sourceSets.test.get()
java.registerFeature(test.name) {
    usingSourceSet(test)
}
