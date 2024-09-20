package com.ru.vsgutu.second_chapter.a;

import com.ru.vsgutu.second_chapter.StringUtils;

public class Task5 {
    public static void main(String[] args) {
        int[] intArray = StringUtils.scanAndGetNumbers();
        printNumberWithMinUniqueDigits(intArray);
    }

    private static void printNumberWithMinUniqueDigits(int[] numbers) {
        int count = 0;

        for (int number : numbers) {
            if (isNumberWithEvenDigits(number)) {
                count++;
            }
        }

        System.out.println("Count numbers with only even digits: " + count);
    }

    private static boolean isNumberWithEvenDigits(int number) {
        boolean result = true;

        while (number > 0) {
            int digit = number % 10;

            if (digit % 2 != 0) {
                result = false;
                break;
            }

            number /= 10;
        }

        return result;
    }
}
