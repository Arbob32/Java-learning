package com.ru.vsgutu.second_chapter.b;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int count = countSignificantZeros(number);
        System.out.println("Number of significant zeros in binary: " + count);
    }

    public static int countSignificantZeros(int number) {
        String binary = Integer.toBinaryString(number);

        int originalLength = binary.length();
        int newLength = binary.replace(String.valueOf('0'), "").length();

        return originalLength - newLength;
    }
}
