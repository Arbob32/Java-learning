package com.ru.vsgutu.first_chapter;

public class PasswordValidator {
    private final static String PASSWORD = "qwerty123";

    public static void validatePassAndPrintResult(final String password) {
        if (password.equals(PASSWORD)) {
            System.out.println("Password is correct!");
        } else {
            System.out.println("Password is incorrect!");
        }
    }
}
