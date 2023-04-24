import com.autonomousapps.AbstractPostProcessingTask
import com.autonomousapps.DependencyAnalysisSubExtension
import com.autonomousapps.model.Advice
import com.autonomousapps.model.ProjectCoordinates

plugins {
    id("java")
}

group = "org.example.my-app"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

val checkDependencyScopes = tasks.register<AbstractPostProcessingTask>("checkDependencyScopes") {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    doLast {
        val advices = projectAdvice().dependencyAdvice
        if (advices.isNotEmpty()) {
            val toAdd = advices.filter { it.toConfiguration != null &&
                    it.toConfiguration != "runtimeOnly" }.map {
                it.declaration(it.toConfiguration) }.sorted()
            val toRemove = advices.filter { it.fromConfiguration != null }.map {
                it.declaration(it.fromConfiguration) }.sorted()

            throw RuntimeException("""
                    ${projectAdvice().projectPath.substring(1)}/build.gradle.kts
                    
                    Please add the following dependency declarations: 
                        ${toAdd.joinToString("\n                        ")  { it }}
                    
                    Please remove the following dependency declarations: 
                        ${toRemove.joinToString("\n                        ")  { it }}
                """.trimIndent())
        }
    }
}

fun Advice.declaration(conf: String?) =
        if (coordinates is ProjectCoordinates) "${conf}(project(\"${coordinates.identifier}\"))"
        else "${conf}(\"${coordinates.identifier}\")"

extensions.findByType<DependencyAnalysisSubExtension>()?.registerPostProcessingTask(
        checkDependencyScopes)

// Add checkDependencyScopes to 'check' lifecycle
tasks.check {
    dependsOn(checkDependencyScopes)
}
