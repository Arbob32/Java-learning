package com.ru.vsgutu.first_chapter;

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
        String evens = new String();
        String odds = new String();

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) {
                evens += intArray[i] + " ";
            } else {
                odds += intArray[i] + " ";
            }
        }

        System.out.println("Четные: " + evens);
        System.out.println("Нечетные: " + odds);
    }

    public void printMaxAndMin() {
        int min = intArray[0];
        int max = intArray[0];

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }

            if (intArray[i] < min) {
                min = intArray[i];
            }
        }

        System.out.println("Минимальное: " + min);
        System.out.println("Максимальное: " + max);
    }

    public void printMultiplesOfThreeOrNine() {
        String result = new String();

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 3 == 0) {
                result += intArray[i] + " ";
            }
        }

        System.out.println("Числа, которые делятся на 3 или на 9: " + result);
    }

    public void printMultiplesOfFiveAndSeven() {
        String result = new String();

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 7 == 0 && intArray[i] % 5 == 0) {
                result += intArray[i] + " ";
            }
        }

        System.out.println("Числа, которые делятся на 5 и 7: " + result);
    }

    public void printUniqueDigitThreeDigitNumbers() {
        String result = new String();

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] >= 100 && intArray[i] <= 999) {
                int hundreds = intArray[i] / 100;
                int tens = (intArray[i] / 10) % 10;
                int units = intArray[i] % 10;

                if (hundreds != tens && tens != units && units != hundreds) {
                    result += intArray[i] + " ";
                }
            }
        }

        System.out.println("Трехзначные числа, без повторяющихся цифр: " + result);
    }

    public void printPrimeNumbers() {
        String result = new String();

        for (int i = 0; i < intArray.length; i++) {
            if (isPrimeNumber(intArray[i])) {
                result += intArray[i] + " ";
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
        String asc = new String();
        String desc = new String();

        for (int i = 0; i < intArray.length; i++) {
            asc += intArray[i] + " ";
        }

        for (int i = intArray.length - 1; i > -1; i--) {
            desc += intArray[i] + " ";
        }

        System.out.println("Сортировка по возрастанию: " + asc);
        System.out.println("Сортировка по убыванию: " + desc);
    }

    public void printDescFrequencyNumbers() {
        String result = new String();
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
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> uniqueNumbersFrequency[b] - uniqueNumbersFrequency[a]);

        for (int i : indices) {
            result += uniqueNumbers[i] + " ";
        }

        System.out.println("Числа в порядке убывания частоты встречаемости: " + result);
    }

    public void printHappyNumbers() {
        String result = new String();

        for (int i = 0; i < intArray.length; i++) {
            if (isHappy(intArray[i])) {
                result += intArray[i] + " ";
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
        String result = new String();

        for (int i = 0; i < intArray.length; i++) {
            if (isPalindrome(intArray[i])) {
                result += intArray[i] + " ";
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
        String result = new String();

        for (int i = 1; i < intArray.length - 1; i++) {
            if (intArray[i] == (intArray[i - 1] + intArray[i + 1]) / 2) {
                result += intArray[i] + " ";
            }
        }

        System.out.println("Элементы, которые равны полусумме соседних элементов: " + result);
    }
}
