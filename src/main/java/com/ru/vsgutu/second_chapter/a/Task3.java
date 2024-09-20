package com.ru.vsgutu.second_chapter.a;

import com.ru.vsgutu.second_chapter.Utils;

public class Task3 {
    public static void main(String[] args) {
        int[] intArray = Utils.scanAndGetNumbers();
        printNumbersWithLengthLessThanAvg(intArray);
    }

    private static void printNumbersWithLengthLessThanAvg(int[] numbers) {
        StringBuilder result = new StringBuilder("Numbers with a length less than average: ");
        int avg = 0;

        for (int number : numbers) {
            avg += String.valueOf(number).length();
        }

        avg = avg / numbers.length;

        for (int number : numbers) {
            if (String.valueOf(number).length() < avg) {
                result.append(number).append(" ");
            }
        }

        System.out.println(result);
    }
}
