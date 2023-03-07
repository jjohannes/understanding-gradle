plugins {
    id("java")
    id("org.gradlex.java-module-dependencies")
}

javaModuleDependencies {
    // The mappings here are already known by the plugin. It also works without defining them here.
    moduleNameToGA.put("jakarta.activation", "jakarta.activation:jakarta.activation-api")
    moduleNameToGA.put("org.slf4j", "org.slf4j:slf4j-api")
    moduleNameToGA.put("jakarta.el", "jakarta.el:jakarta.el-api")
    moduleNameToGA.put("jakarta.servlet", "jakarta.servlet:jakarta.servlet-api")
}

group = "org.example"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies.constraints {
    javaModuleDependencies {
        implementation(gav("jakarta.activation", "2.1.1"))
        implementation(gav("org.slf4j", "2.0.3"))
        implementation(gav("jakarta.el", "5.0.1"))
        implementation(gav("jakarta.servlet", "6.0.0"))
    }
}
