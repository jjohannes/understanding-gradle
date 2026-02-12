package myproject.services;

import myproject.data.test.MessageModelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void verifyCustomFactory(@TempDir Path temp) {
        System.out.println("Temp dir: " + temp);
        assertTrue(temp.toString().contains("build/junit"),
            "Expected temp dir under build/junit but got: " + temp);
    }

    @Test
    void emoji_in_message_is_encoded() {
        assertEquals(
                "Hi \uD83D\uDE03",
                Service.printMessage(MessageModelFixture.newMessage())
        );
    }
}
