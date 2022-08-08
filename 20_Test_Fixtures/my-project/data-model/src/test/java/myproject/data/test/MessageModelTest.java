package myproject.data.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageModelTest {

    @Test
    void model_contains_message_text_it_was_created_with() {
        assertEquals(
                "Hi :)",
                MessageModelFixture.newMessage().getMessage());
    }
}
