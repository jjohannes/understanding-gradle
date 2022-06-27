plugins {
    id("my-java-library")
}

dependencies {
    jsonImplementation(project(path))
    jsonImplementation("com.fasterxml.jackson.core:jackson-databind")
    jsonImplementation("com.fasterxml.jackson.module:jackson-module-parameter-names")

    xmlImplementation(project(path))
    xmlImplementation("com.fasterxml.jackson.core:jackson-databind")
    xmlImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    xmlImplementation("com.fasterxml.jackson.module:jackson-module-parameter-names")
}
