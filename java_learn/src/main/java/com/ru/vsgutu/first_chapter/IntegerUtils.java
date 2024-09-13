package com.ru.vsgutu.first_chapter;

public class IntegerUtils {
    public static void sumAndPrint(String[] args) {
        int result = 0;
        for (String arg: args) {
            result += Integer.parseInt(arg);
        }

        System.out.println(result);
    }

    public static void multAndPrint(String[] args) {
        int result = 1;
        for (String arg: args) {
            result *= Integer.parseInt(arg);
        }

        System.out.println(result);
    }
}
