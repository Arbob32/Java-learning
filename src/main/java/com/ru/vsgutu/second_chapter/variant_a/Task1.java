package com.ru.vsgutu.second_chapter.variant_a;

public class Task1 {
    public static void main(String[] args) {
        int[] intArray = Utils.scanAndGetNumbers();
        printShortestAndLongest(intArray);
    }

    private static void printShortestAndLongest(int[] intArray) {
        int max = intArray[0];
        int min = intArray[0];
        int maxLength = String.valueOf(intArray[0]).length();
        int minLength = String.valueOf(intArray[0]).length();

        for (int number : intArray) {
            int currentLength = String.valueOf(number).length();

            if (currentLength > maxLength) {
                max = number;
                maxLength = currentLength;
            } else if (currentLength < minLength) {
                min = number;
                minLength = currentLength;
            }
        }

        System.out.println("Longest: " + max + " with length " + maxLength);
        System.out.println("Shortest: " + min + " with length " + minLength);
    }
}
