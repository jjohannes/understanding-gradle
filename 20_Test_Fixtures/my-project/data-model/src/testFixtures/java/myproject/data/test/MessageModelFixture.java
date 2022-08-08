package myproject.data.test;

import myproject.data.MessageModel;

public class MessageModelFixture {

    public static MessageModel newMessage() {
        return new MessageModel("Hi :)");
    }
}
