plugins {
    id("my-java-base")
    id("java-library")
}

val json = sourceSets.create("json")
val xml = sourceSets.create("xml")

// java.registerFeature(json.name) {
//     usingSourceSet(json)
//     capability(project.group.toString(), "${project.name}-json", project.version.toString())
//     capability(project.group.toString(), "${project.name}-serialization", project.version.toString())
// }

// Setting up what 'registerFeature(json.name)' ↑ would do step-by-step
tasks.register<Jar>(json.jarTaskName) {
    from(json.output)
    archiveClassifier.set(json.name)
}

val apiElements = configurations.create(json.apiElementsConfigurationName) {
    isCanBeResolved = false
    isCanBeConsumed = true

    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API))
        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.LIBRARY))
        attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named(LibraryElements.JAR))
    }

    extendsFrom(configurations.getByName(json.implementationConfigurationName))

    outgoing.artifact(tasks.named(json.jarTaskName))

    outgoing.capability("${project.group}:${project.name}-${json.name}:${project.version}")
    outgoing.capability("${project.group}:${project.name}-serialization:${project.version}")
}

val runtimeElements = configurations.create(json.runtimeElementsConfigurationName) {
    isCanBeResolved = false
    isCanBeConsumed = true

    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.LIBRARY))
        attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named(LibraryElements.JAR))
    }

    extendsFrom(configurations.getByName(json.implementationConfigurationName))

    outgoing.artifact(tasks.named(json.jarTaskName))

    outgoing.capability("${project.group}:${project.name}-${json.name}:${project.version}")
    outgoing.capability("${project.group}:${project.name}-serialization:${project.version}")
}

val javaComponent = components["java"] as AdhocComponentWithVariants
javaComponent.addVariantsFromConfiguration(apiElements) {
    mapToOptional()
}
javaComponent.addVariantsFromConfiguration(runtimeElements) {
    mapToOptional()
}


java.registerFeature(xml.name) {
    usingSourceSet(xml)
    capability(project.group.toString(), "${project.name}-xml", project.version.toString())
    capability(project.group.toString(), "${project.name}-serialization", project.version.toString())
}


// Centralized versions
dependencies {
    "jsonImplementation"(platform("com.fasterxml.jackson:jackson-bom:2.20.1"))
    "xmlImplementation"(platform("com.fasterxml.jackson:jackson-bom:2.20.1"))
}
