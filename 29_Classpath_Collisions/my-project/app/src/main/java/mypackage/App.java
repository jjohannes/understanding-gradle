package mypackage;

import javax.activation.MimeType;

public class App {

    public static void main(String[] args) {
        System.out.println(MimeType.class.getProtectionDomain().getCodeSource().getLocation());
    }
}
