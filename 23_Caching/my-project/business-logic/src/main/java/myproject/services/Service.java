package myproject.services;

import myproject.data.MessageModel;
import org.apache.commons.lang3.StringUtils;

public final class Service {

    public static String printMessage(MessageModel message) {
        String trimmedMessage = StringUtils.trimToEmpty(message.getMessage());
        String encodedMessage = encode(trimmedMessage);
        System.out.println(encodedMessage);
        return encodedMessage;
    }

    public static String encode(String s) {
        return s.replace(":)", "\uD83D\uDE03");
    }
}
