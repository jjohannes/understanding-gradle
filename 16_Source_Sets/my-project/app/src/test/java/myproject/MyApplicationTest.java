package myproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyApplicationTest {

    @Test
    public void testApp() {
        assertEquals("Hello there :)", MyApplication.readeMessageTxt());
    }
}
