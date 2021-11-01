package myproject.services;

import myproject.data.MessageModel;
import org.slf4j.LoggerFactory;

public final class Service {

    public static String printMessage(MessageModel message) {
        String messageToPrint = message.getMessage();
        System.out.println(messageToPrint);
        LoggerFactory.getLogger(Service.class).info("Message printed");
        return messageToPrint;
    }
}
