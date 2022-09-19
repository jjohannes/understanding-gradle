pluginManagement {
    includeBuild("../my-build-logic")
}
dependencyResolutionManagement {
    repositories.mavenCentral()
}

rootDir.listFiles()?.filter { File(it, "build.gradle.kts").exists() }?.forEach {
    include(it.name)
}

val runsOnCI = providers.environmentVariable("CI").getOrElse("false").toBoolean()
buildCache {
    remote<HttpBuildCache> {
        isEnabled = false // because this example cache does not actually exist :)
        url = uri("https://onepiece.software/cache/")
        credentials {
            username = "jendrik"
            password = "..."
        }
        isPush = runsOnCI
    }
    local {
        // isEnabled = false
        // directory = File(rootDir, "build-cache")
        // removeUnusedEntriesAfterDays = 30
    }
}
