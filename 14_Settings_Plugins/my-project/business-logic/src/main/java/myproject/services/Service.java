package myproject.services;

import myproject.shared.util.EmojiEncodeUtil;
import myproject.data.MessageModel;
import org.apache.commons.lang3.StringUtils;

public final class Service {

    public static String printMessage(MessageModel message) {
        String trimmedMessage = StringUtils.trimToEmpty(message.getMessage());
        String encodedMessage = EmojiEncodeUtil.encode(trimmedMessage);
        System.out.println(encodedMessage);
        return encodedMessage;
    }
}
