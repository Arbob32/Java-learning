package com.ru.vsgutu.second_chapter.a;

import com.ru.vsgutu.second_chapter.Utils;

import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) {
        int[] intArray = Utils.scanAndGetNumbers();
        printPalindromeNumber(intArray);
    }

    private static void printPalindromeNumber(int[] numbers) {
        int result = 0;
        boolean firstDone = false;

        for (int number : numbers) {
            if (isPalindrome(number)) {
                result = number;

                if (firstDone) {
                    break;
                }

                firstDone = true;
            }
        }

        System.out.println("First (second) palindrome number: " + result);
    }

    private static boolean isPalindrome(int number) {
        boolean result = false;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(number));
        String stringNumber = stringBuilder.toString();
        String reverseStringNumber = stringBuilder.reverse().toString();

        if (stringNumber.equals(reverseStringNumber) && stringNumber.length() > 1) {
            result = true;
        }

        return result;
    }
}
