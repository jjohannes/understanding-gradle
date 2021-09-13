package myproject.tasks

import org.gradle.api.provider.Property

interface MyAppExtension {
    val mainClass: Property<String>
}
