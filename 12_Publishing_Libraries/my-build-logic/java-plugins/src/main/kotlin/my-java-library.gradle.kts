plugins {
    id("my-java-base")
    id("java-library")
    id("maven-publish")
}

publishing {
    publications.create<MavenPublication>("lib").from(components["java"])

    repositories.maven("/tmp/test-repo")
}

// The above more verbose if you need to customize published 'variants':
//
// val javaComponent = components["java"] as AdhocComponentWithVariants
// javaComponent.withVariantsFromConfiguration(configurations.runtimeElements.get()) {
//     // customize 'runtimeElements' variant here...
// }
// publishing {
//     publications.create<MavenPublication>("lib").from(javaComponent)
//
//     repositories.maven("/tmp/test-repo") {
//         name = "myRepo"
//         credentials(PasswordCredentials::class)
//     }
// }