package com.ru.vsgutu.chapter1;

import java.util.Random;

public class Randomizer {
    public static void printRandomNumbersWithNewLine(int count) {
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            int randomNum = rand.nextInt(101);
            System.out.println(randomNum);
        }
    }

    public static void printRandomNumbers(int count) {
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            int randomNum = rand.nextInt(101);
            System.out.print(String.valueOf(randomNum) + " ");
        }
    }
}
