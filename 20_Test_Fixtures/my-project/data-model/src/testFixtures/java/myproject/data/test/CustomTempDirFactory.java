package myproject.data.test;

import org.junit.jupiter.api.extension.AnnotatedElementContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.io.TempDirFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomTempDirFactory implements TempDirFactory {
    @Override
    public Path createTempDirectory(
        AnnotatedElementContext elementContext,
        ExtensionContext extensionContext
    ) throws IOException
    {
        String baseDir = System.getProperty("test.tempdir.baseDir");
        System.err.println("=== CustomTempDirFactory invoked ===");
        System.err.println("test.tempdir.baseDir property: " + baseDir);
        System.err.println("Current working dir: " + System.getProperty("user.dir"));

        if (baseDir == null || baseDir.isEmpty()) {
            throw new IllegalStateException("test.tempdir.baseDir not set!");
        }
        Path customBaseDir = Path.of(baseDir);
        Files.createDirectories(customBaseDir); // Ensure the base directory exists
        return Files.createTempDirectory(customBaseDir, "junit");
    }
}
