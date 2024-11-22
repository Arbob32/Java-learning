package com.ru.vsgutu.chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class IntegerUtils {
    private int[] intArray;

    public static void sumAndPrint(String[] args) {
        int result = 0;
        for (String arg : args) {
            result += Integer.parseInt(arg);
        }

        System.out.println(result);
    }

    public static void multAndPrint(String[] args) {
        int result = 1;
        for (String arg : args) {
            result *= Integer.parseInt(arg);
        }

        System.out.println(result);
    }

    public void scanAndSetIntNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n: ");
        int n = scanner.nextInt();
        intArray = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("%d: ", i);
            intArray[i] = scanner.nextInt();
        }

        scanner.close();
    }

    public void printOddsAndEvens() {
        StringBuilder evens = new StringBuilder();
        StringBuilder odds = new StringBuilder();

        for (int j : intArray) {
            if (j % 2 == 0) {
                evens.append(j).append(" ");
            } else {
                odds.append(j).append(" ");
            }
        }

        System.out.println("Четные: " + evens);
        System.out.println("Нечетные: " + odds);
    }

    public void printMaxAndMin() {
        int min = intArray[0];
        int max = intArray[0];

        for (int j : intArray) {
            if (j > max) {
                max = j;
            }

            if (j < min) {
                min = j;
            }
        }

        System.out.println("Минимальное: " + min);
        System.out.println("Максимальное: " + max);
    }

    public void printMultiplesOfThreeOrNine() {
        StringBuilder result = new StringBuilder();

        for (int j : intArray) {
            if (j % 3 == 0) {
                result.append(j).append(" ");
            }
        }

        System.out.println("Числа, которые делятся на 3 или на 9: " + result);
    }

    public void printMultiplesOfFiveAndSeven() {
        StringBuilder result = new StringBuilder();

        for (int j : intArray) {
            if (j % 7 == 0 && j % 5 == 0) {
                result.append(j).append(" ");
            }
        }

        System.out.println("Числа, которые делятся на 5 и 7: " + result);
    }

    public void printUniqueDigitThreeDigitNumbers() {
        StringBuilder result = new StringBuilder();

        for (int j : intArray) {
            if (j >= 100 && j <= 999) {
                int hundreds = j / 100;
                int tens = (j / 10) % 10;
                int units = j % 10;

                if (hundreds != tens && tens != units && units != hundreds) {
                    result.append(j).append(" ");
                }
            }
        }

        System.out.println("Трехзначные числа, без повторяющихся цифр: " + result);
    }

    public void printPrimeNumbers() {
        StringBuilder result = new StringBuilder();

        for (int j : intArray) {
            if (isPrimeNumber(j)) {
                result.append(j).append(" ");
            }
        }

        System.out.println("Простые числа: " + result);
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void printAscAndDescNumbers() {
        Arrays.sort(intArray);
        StringBuilder asc = new StringBuilder();
        StringBuilder desc = new StringBuilder();

        for (int j : intArray) {
            asc.append(j).append(" ");
        }

        for (int i = intArray.length - 1; i > -1; i--) {
            desc.append(intArray[i]).append(" ");
        }

        System.out.println("Сортировка по возрастанию: " + asc);
        System.out.println("Сортировка по убыванию: " + desc);
    }

    public void printDescFrequencyNumbers() {
        StringBuilder result = new StringBuilder();
        Arrays.sort(intArray);
        int[] uniqueNumbers = new int[intArray.length];
        int[] uniqueNumbersFrequency = new int[intArray.length];

        int j = 0;
        int count = 0;

        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] == intArray[i - 1]) {
                count += 1;
            } else {
                uniqueNumbers[j] = intArray[i - 1];
                uniqueNumbersFrequency[j] = count;
                count = 0;
                j++;
            }
        }

        // Добавить последнее уникальное число и его частоту
        uniqueNumbers[j] = intArray[intArray.length - 1];
        uniqueNumbersFrequency[j] = count;

        // Создать массив индексов и отсортировать его в порядке убывания частот
        Integer[] indices = new Integer[j + 1];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = Integer.valueOf(i);
        }
        Arrays.sort(indices, (a, b) -> uniqueNumbersFrequency[b] - uniqueNumbersFrequency[a]);

        for (int i : indices) {
            result.append(uniqueNumbers[i]).append(" ");
        }

        System.out.println("Числа в порядке убывания частоты встречаемости: " + result);
    }

    public void printHappyNumbers() {
        StringBuilder result = new StringBuilder();

        for (int j : intArray) {
            if (isHappy(j)) {
                result.append(j).append(" ");
            }
        }

        System.out.println("Счастливые числа: " + result);
    }

    private boolean isHappy(int number) {
        int start = number;
        boolean result = true;
        int sumResult = 0;

        while (sumResult != 1) {
            sumResult = sumOfSquaresOfDigits(number);
            number = sumResult;

            if (sumResult == start) {
                result = false;
                break;
            }
        }

        return result;
    }

    private int sumOfSquaresOfDigits(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    public void printPalindromeNumbers() {
        StringBuilder result = new StringBuilder();

        for (int j : intArray) {
            if (isPalindrome(j)) {
                result.append(j).append(" ");
            }
        }

        System.out.println("Числа палиндромы: " + result);
    }

    private boolean isPalindrome(int number) {
        String str = Integer.toString(number);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public void printElementsWithNeighbors() {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < intArray.length - 1; i++) {
            if (intArray[i] == (intArray[i - 1] + intArray[i + 1]) / 2) {
                result.append(intArray[i]).append(" ");
            }
        }

        System.out.println("Элементы, которые равны полусумме соседних элементов: " + result);
    }
}
