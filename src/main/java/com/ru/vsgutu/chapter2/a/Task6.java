package com.ru.vsgutu.chapter2.a;

import com.ru.vsgutu.chapter2.Utils;

public class Task6 {
    public static void main(String[] args) {
        int[] intArray = Utils.scanAndGetNumbers();
        printNumberWithAscDigits(intArray);
    }

    private static void printNumberWithAscDigits(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            if (isNumberWithAscDigits(number)) {
                result = number;
                break;
            }
        }

        System.out.println("First number with asc digits: " + result);
    }

    private static boolean isNumberWithAscDigits(int number) {
        boolean result = true;
        int nextDigit = number % 10;
        number /= 10;

        if (number != 0) {
            while (number > 0) {
                int digit = number % 10;

                if (digit > nextDigit) {
                    result = false;
                    break;
                }

                nextDigit = digit;
                number /= 10;
            }
        } else {
            result = false;
        }

        return result;
    }
}
