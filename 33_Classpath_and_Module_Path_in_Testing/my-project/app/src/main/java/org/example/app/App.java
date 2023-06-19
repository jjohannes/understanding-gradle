package org.example.app;

public class App {

    public static void main(String[] args) {
        printModuleName();
    }

    protected static void printModuleName() {
        System.out.println("Production Module: " +
                App.class.getModule().getName());
    }
}

