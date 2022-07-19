package myproject;

import myproject.data.MessageModel;
import myproject.services.Service;

public final class MyApplication {

    public static void main(final String[] args) {
        Service.printMessage(new MessageModel("Hello there :)"));
    }
}
