repositories.mavenCentral()

val implementation = configurations.create("implementation")
val runtimeOnly = configurations.create("runtimeOnly")
val compileClasspath = configurations.create("compileClasspath") {
    extendsFrom(implementation)
}
val runtimeClasspath = configurations.create("runtimeClasspath") {
    extendsFrom(implementation, runtimeOnly)
}

// Other classpath configurations we should have:
// - testCompileClasspath
// - testRuntimeClasspath

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("junit:junit:4.13.2") // <-- would be testImplementation in a real project
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
}

val compileJava = tasks.register<JavaCompile>("compileJava") {
    destinationDirectory.set(layout.buildDirectory.dir("classes"))
    source(layout.projectDirectory.dir("src"))
    sourceCompatibility = "11"
    targetCompatibility = "11"
    classpath = files(compileClasspath)
}

tasks.register<JavaExec>("run") {
    mainClass.set("mypackage.App")
    classpath = files(compileJava, runtimeClasspath)
}

tasks.register<Test>("test") {
    testClassesDirs = files(compileJava)
    classpath = files(compileJava, runtimeClasspath)
    binaryResultsDirectory.set(layout.buildDirectory.dir("test-results"))
    reports.junitXml.required.set(false)
    reports.html.required.set(false)
}