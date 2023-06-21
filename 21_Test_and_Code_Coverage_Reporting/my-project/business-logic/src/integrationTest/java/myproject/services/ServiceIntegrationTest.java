package myproject.services;

import myproject.data.MessageModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceIntegrationTest {

    @Test
    void testService() {
        assertEquals(
                "Hi \uD83D\uDE03",
                Service.printMessage(new MessageModel("Hi :)"))
        );
    }
}
