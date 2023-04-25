package org.example;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.slf4j.Logger;

public class App {

    public static void main(String[] args) {
        System.out.println(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(App.class.getModule().getDescriptor().exports());
        System.out.println(Logger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(Logger.class.getModule().getDescriptor().exports());
        System.out.println(CaseUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(CaseUtils.class.getModule().getDescriptor().exports());
        System.out.println(StringUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(StringUtils.class.getModule().getDescriptor().exports());
    }
}
