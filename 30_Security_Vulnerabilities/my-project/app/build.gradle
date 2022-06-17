plugins {
    id("my-java-application")
}

application {
    mainClass.set("mypackage.App")
}

dependencies {
    implementation(project(":module"))
    implementation("javax.activation:activation:1.1.1")
    implementation("org.slf4j:slf4j-api:2.0.17")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
}

// dependencies.constraints {
//     implementation("commons-io:commons-io:2.8"
// }

