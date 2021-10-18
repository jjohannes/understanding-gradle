package myproject.services;

import myproject.data.MessageModel;
import org.apache.commons.lang3.math.NumberUtils;

public final class Service {

    public static String printMessage(MessageModel message) {
        String messageToPrint = message.getMessage();
        if (NumberUtils.isCreatable(messageToPrint)) {
            messageToPrint += " has no leading zeros";
        }
        System.out.println(messageToPrint);
        return messageToPrint;
    }
}
