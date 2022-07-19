package myproject.services;

import myproject.data.MessageModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Service8Test {

    @Test
    public void testEncoding() throws InterruptedException {
        assertEquals("Hi \uD83D\uDE03", Service.printMessage(new MessageModel("Hi :)")));
        Thread.sleep(500);
    }
}
