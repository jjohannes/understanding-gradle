import org.example.JavaModuleTransform
import org.gradle.api.artifacts.type.ArtifactTypeDefinition.ARTIFACT_TYPE_ATTRIBUTE

plugins {
    id("java")
    // id("org.gradlex.extra-java-module-info")
}

// extraJavaModuleInfo {
//     module("org.apache.commons:commons-text", "org.apache.commons.text") {
//         requires("org.apache.commons.lang3")
//         exportAllPackages()
//     }
//
//     module("org.apache.commons:commons-lang3", "org.apache.commons.lang3") {
//         exportAllPackages()
//     }
// }

val javaModuleAttribute = Attribute.of("javaModule", Boolean::class.javaObjectType)
configurations.compileClasspath {
    attributes.attribute(javaModuleAttribute, true)
}
configurations.runtimeClasspath {
    attributes.attribute(javaModuleAttribute, true)
}

dependencies.artifactTypes.maybeCreate("jar").attributes.attribute(javaModuleAttribute, false)

dependencies.registerTransform(JavaModuleTransform::class) {
    from.attributes.attribute(ARTIFACT_TYPE_ATTRIBUTE, "jar").attribute(javaModuleAttribute, false)
    to.attributes.attribute(ARTIFACT_TYPE_ATTRIBUTE, "jar").attribute(javaModuleAttribute, true)
}


group = "org.example"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies.constraints {
    implementation("org.slf4j:slf4j-api:2.0.3")
    implementation("org.apache.commons:commons-text:1.10.0")
    implementation("org.apache.commons:commons-lang3:3.12.0")
}
