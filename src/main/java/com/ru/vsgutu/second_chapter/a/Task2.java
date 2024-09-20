package com.ru.vsgutu.second_chapter.a;

import com.ru.vsgutu.second_chapter.StringUtils;

public class Task2 {
    public static void main(String[] args) {
        int[] intArray = StringUtils.scanAndGetNumbers();
        bubbleSortByLengthAscAndPrint(intArray);
    }

    private static void bubbleSortByLengthAscAndPrint(int[] numbers) {
        StringBuilder result = new StringBuilder("Sorted by length asc: ");

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (String.valueOf(numbers[j]).length() > String.valueOf(numbers[j + 1]).length()) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for (int number : numbers) {
            result.append(number).append(" ");
        }

        System.out.println(result);
    }
}
