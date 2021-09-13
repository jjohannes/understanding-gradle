package myproject.services;

import myproject.data.MessageModel;
import org.apache.commons.lang3.StringUtils;

/**
 * Our main service.
 */
public final class Service {

    /**
     * Prints the main message to screen.
     */
    public static void printMessage() {
        String x = "";
        MessageModel m1 = new MessageModel();
        String m = StringUtils.trimToEmpty(m1.getMessage());
        System.out.println(m + x);
    }
}
