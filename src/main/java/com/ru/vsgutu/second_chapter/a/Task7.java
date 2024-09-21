package com.ru.vsgutu.second_chapter.a;

import com.ru.vsgutu.second_chapter.Utils;
import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        int[] intArray = Utils.scanAndGetNumbers();
        printNumberWithUniqueDigits(intArray);
    }

    private static void printNumberWithUniqueDigits(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            if (isNumberWithUniqueDigits(number)) {
                result = number;
                break;
            }
        }

        System.out.println("First number with unique digits: " + result);
    }

    private static boolean isNumberWithUniqueDigits(int number) {
        boolean result = true;
        boolean[] digits = new boolean[10];
        Arrays.fill(digits, false);

        while (number > 0) {
            int digit = number % 10;

            if (digits[digit]) {
                result = false;
                break;
            }

            digits[digit] = true;
            number /= 10;
        }

        return result;
    }
}
