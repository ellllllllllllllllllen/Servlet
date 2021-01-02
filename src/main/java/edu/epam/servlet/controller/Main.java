package edu.epam.servlet.controller;

import edu.epam.servlet.config.DBConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {


    private static final String FILENAME = "resources/property.text/text.properties";
    public static void main(String[] args) throws SQLException {



//        System.out.println("1 - bel \n2 - eng \nany - default");
//        char i = 0;
//        try {
//            i = (char)System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String country = "";
//        String language = "";
//        switch (i){
//            case '1':
//                country = "BY";
//                language = "be";
//                break;
//
//            case '2':
//                country = "US";
//                language = "en";
//                break;
//        }
//        Locale current = new Locale(language, country);
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("text", current);
//        String str1 = resourceBundle.getString("str1");
//        System.out.println(str1);
//        String str2 = resourceBundle.getString("str2");
//        System.out.println(str2);
    }
}
