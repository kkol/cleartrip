package com.travels.aut.autSubname.ux.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static Properties appliactionProperty = new Properties();

    public static Properties getApplicationProperty() {
        try {
            appliactionProperty.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appliactionProperty;
    }
}