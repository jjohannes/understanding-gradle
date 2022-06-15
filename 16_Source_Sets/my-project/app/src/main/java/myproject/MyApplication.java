package myproject;

import myproject.data.MessageModel;
import myproject.services.Service;

import java.util.Scanner;

public final class MyApplication {

    public static void main(final String[] args) {
        Service.printMessage(new MessageModel(readeMessageTxt()));
    }

    static String readeMessageTxt() {
        //noinspection ConstantConditions
        return new Scanner(MyApplication.class.getResourceAsStream("message.txt"))
                .useDelimiter("\n").next();
    }
}
