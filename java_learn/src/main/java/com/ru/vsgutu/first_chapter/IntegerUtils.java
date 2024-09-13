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
}
