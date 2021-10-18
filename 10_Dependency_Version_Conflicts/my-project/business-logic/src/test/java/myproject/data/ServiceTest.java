package myproject.data;

import myproject.services.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ServiceTest {

    @Test
    void testService() {
        String printed = Service.printMessage(new MessageModel("007.26"));
        Assertions.assertEquals("007.26", printed);
    }
}
