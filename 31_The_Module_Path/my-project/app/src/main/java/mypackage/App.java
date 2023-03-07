package mypackage;

import jakarta.activation.MimeType;
import mypackage.modulea.ModuleA;

public class App {

    public static void main(String[] args) {
        System.out.println(App.class.getModule().getName());
        new MimeType();
        new ModuleA();
    }
}
