package org.example.app;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

class AppTest {

    @Test
    void testAppModule() throws IOException {
        App.printModuleName();
        System.out.println("Test Module:       " +
                AppTest.class.getModule().getName());
        System.out.println(
                new String(AppTest.class.getResourceAsStream("/test-data.txt")
                        .readAllBytes(), UTF_8));
    }
}
