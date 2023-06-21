package myproject.services;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("slow")
public class ServiceSlowTest {

    @Test
    void testEncodingSlow() {
        assertEquals(
                "Hi \uD83D\uDE03",
                Service.encode("Hi :)")
        );
    }
}
