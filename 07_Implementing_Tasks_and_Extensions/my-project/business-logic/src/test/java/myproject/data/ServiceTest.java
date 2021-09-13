package myproject.data;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * Test suite for our service.
 */
public class ServiceTest {

    private static final int CONNECTION_TEST_ATTEMPTS = 20;

    /**
     * The ultimate test for our service.
     */
    @Test
    void testConnection() throws Exception {
        for (int i = 0; i < CONNECTION_TEST_ATTEMPTS; i++) {
            System.out.println("Connection Attempt " + (i + 1)
                    + "/" + CONNECTION_TEST_ATTEMPTS);
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }
    }
}
