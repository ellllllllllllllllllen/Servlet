package edu.epam.servlet.validation;

public class NumberValidator {
    private static final String NUMBER_REGEX = "^-?\\d*(\\.\\d+)?$";
    public static boolean isDataValid(String number){
        return number.matches(NUMBER_REGEX);
    }
}
