package myproject.tasks

import org.gradle.api.provider.Property

interface MyAppExtension {
    Property<String> getMainClass()
}
