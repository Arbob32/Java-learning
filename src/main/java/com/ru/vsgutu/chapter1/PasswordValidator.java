package com.ru.vsgutu.chapter1;

public class PasswordValidator {
    private static final String PASSWORD = "qwerty123";

    public static void validatePassAndPrintResult(final String password) {
        if (password.equals(PASSWORD)) {
            System.out.println("Password is correct!");
        } else {
            System.out.println("Password is incorrect!");
        }
    }
}
