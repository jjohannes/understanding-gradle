package myproject.services;

import myproject.data.MessageModel;
import org.apache.commons.lang3.StringUtils;

public class Service {

    public static void printMessage() {
        MessageModel m1 = new MessageModel();
        String m = StringUtils.trimToEmpty(m1.getMessage());
        System.out.println(m);
    }
}
