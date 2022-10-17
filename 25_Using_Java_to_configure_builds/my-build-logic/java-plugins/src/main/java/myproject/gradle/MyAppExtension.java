package myproject.gradle;

import org.gradle.api.provider.Property;

public interface MyAppExtension {
    Property<String> getMainClass();
}
