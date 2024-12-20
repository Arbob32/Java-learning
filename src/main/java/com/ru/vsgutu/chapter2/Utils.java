package com.ru.vsgutu.chapter2;

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

    public static void printMatrix(int[][] intMatrix, String title) {
        System.out.print("\n" + title);
        for (int i = 0; i < intMatrix.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < intMatrix[i].length; j++) {
                System.out.printf("%4d", intMatrix[i][j]);
            }
        }
    }
}
