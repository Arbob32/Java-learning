package com.ru.vsgutu.second_chapter;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static int[] scanAndGetNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n: ");
        int n = scanner.nextInt();
        int[] intArray = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("%d: ", i);
            intArray[i] = scanner.nextInt();
        }

        scanner.close();
        return intArray;
    }

    public static int[][] scanAndGetMatrix() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("n: ");
        int n = scanner.nextInt();
        int[][] intMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                intMatrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        scanner.close();
        return intMatrix;
    }

    public static int scanAndGetInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("int: ");
        return scanner.nextInt();
    }
}
