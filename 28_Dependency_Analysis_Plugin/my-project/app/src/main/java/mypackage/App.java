package mypackage;

import mypackage.modulea.ModuleA;
import org.slf4j.LoggerFactory;
import javax.activation.MimeType;

public class App extends ModuleA {

    public static void main(String[] args) {
        LoggerFactory.getLogger(App.class).info("running app");
        new App().doWork(new MimeType());
    }
}
