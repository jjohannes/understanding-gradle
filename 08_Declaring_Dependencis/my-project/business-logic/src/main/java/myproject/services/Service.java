package myproject.services;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import myproject.shared.util.EmojiEncodeUtil;
import myproject.data.MessageModel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

public final class Service {
    @CanIgnoreReturnValue
    public static String printMessage(MessageModel message) {
        String trimmedMessage = StringUtils.trimToEmpty(message.getMessage());
        String encodedMessage = EmojiEncodeUtil.encode(trimmedMessage);
        System.out.println(encodedMessage);
        LoggerFactory.getLogger(Service.class).info("Message printed");
        return encodedMessage;
    }
}
