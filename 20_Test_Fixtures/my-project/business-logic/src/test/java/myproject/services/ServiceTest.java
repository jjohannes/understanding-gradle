package myproject.services;

import myproject.data.test.MessageModelFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    void emoji_in_message_is_encoded() {
        assertEquals(
                "Hi \uD83D\uDE03",
                Service.printMessage(MessageModelFixture.newMessage())
        );
    }
}
