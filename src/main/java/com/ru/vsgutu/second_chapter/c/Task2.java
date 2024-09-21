package com.ru.vsgutu.second_chapter.c;

import com.ru.vsgutu.second_chapter.Utils;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int[][] intMatrix = Utils.scanAndGetMatrix();

        Utils.printMatrix(intMatrix, "Init matrix");
        printCycleMatrixShift(intMatrix, k);
    }

    private static void printCycleMatrixShift(int[][] intMatrix, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < intMatrix.length; j++) {
                int last = intMatrix[j][intMatrix.length - 1];
                for (int l = intMatrix[j].length - 1; l > 0; l--) {
                    intMatrix[j][l] = intMatrix[j][l - 1];
                }
                intMatrix[j][0] = last;
            }
        }

        Utils.printMatrix(intMatrix, "Shifted matrix");
    }
}
