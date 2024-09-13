package com.ru.vsgutu.first_chapter;

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
        String result = new String();

        for (int i = 0; i < count; i++) {
            int randomNum = rand.nextInt(101);
            result += String.valueOf(randomNum) + " ";
        }

        System.out.println(result);
    }
}
