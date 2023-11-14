package com.dsa;

import java.io.InputStream;
import java.util.Properties;

public class MyConsoleApp {

    public static void main(String[] args) {
        System.out.println("some-key =>" + getVar("some-key"));
        System.out.println("Hello, Console!");
    }

    public static String getVar(String Key) {
        try (InputStream input = MyConsoleApp.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return "";
            }

            Properties properties = new Properties();
            properties.load(input);

            // Access properties
            String value = properties.getProperty(Key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
