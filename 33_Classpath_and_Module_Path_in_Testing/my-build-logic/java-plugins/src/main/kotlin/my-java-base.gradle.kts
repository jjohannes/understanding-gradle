plugins {
    id("java")
    id("java-test-fixtures")
    id("org.gradlex.java-module-testing")
}

group = "org.example"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

javaModuleTesting.whitebox(testing.suites.getByName("test")) {
    requires.add("org.junit.jupiter.api")
    opensTo.add("org.junit.platform.commons")
}

tasks.test {
    useJUnitPlatform() // JUnit5
}
