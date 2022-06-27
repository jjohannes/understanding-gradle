package myproject;

import myproject.data.serialization.Serializer;
import myproject.services.Service;

import java.io.File;

public final class MyApplication {

    public static void main(final String[] args) {
        Serializer serializer = new Serializer(new File("data"));
        Service.printMessage(serializer.parse());
    }
}
