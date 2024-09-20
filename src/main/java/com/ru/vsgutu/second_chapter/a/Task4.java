package com.ru.vsgutu.second_chapter.a;

import java.util.Arrays;

import com.ru.vsgutu.second_chapter.StringUtils;

public class Task4 {
    public static void main(String[] args) {
        int[] intArray = StringUtils.scanAndGetNumbers();
        printNumberWithMinUniqueDigits(intArray);
    }

    private static void printNumberWithMinUniqueDigits(int[] numbers) {
        int minUniqueDigits = Integer.MAX_VALUE;
        int result = numbers[0];

        for (int number : numbers) {
            int uniqueDigits = countUniqueDigits(number);

            if (uniqueDigits < minUniqueDigits) {
                minUniqueDigits = uniqueDigits;
                result = number;
            }
        }

        System.out.println("First number with min unique digits: " + result);
    }

    private static int countUniqueDigits(int number) {
        boolean[] digits = new boolean[10];
        Arrays.fill(digits, false);

        while (number > 0) {
            digits[number % 10] = true;
            number /= 10;
        }

        int count = 0;
        for (boolean digit : digits) {
            if (digit) {
                count++;
            }
        }

        return count;
    }
}
