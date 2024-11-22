package com.ru.vsgutu.chapter2.c;

import com.ru.vsgutu.chapter2.Utils;

public class Task4 {
    public static void main(String[] args) {
        int[][] intMatrix = Utils.scanAndGetMatrix();

        Utils.printMatrix(intMatrix, "Init matrix");
        printSumOfEveryRowBetweenPositive(intMatrix);
    }

    private static void printSumOfEveryRowBetweenPositive(int[][] intMatrix) {
        for (int i = 0; i < intMatrix.length; i++) {
            int sum = 0;
            boolean firstPositiveFound = false;

            for (int j = 0; j < intMatrix[i].length; j++) {
                if (intMatrix[i][j] > 0) {
                    if (firstPositiveFound) {
                        System.out.println(
                                "\nSum between first and second positive numbers in row "
                                        + i
                                        + ": "
                                        + sum);
                        break;
                    } else {
                        firstPositiveFound = true;
                    }
                } else if (firstPositiveFound) {
                    sum += intMatrix[i][j];
                }
            }
        }
    }
}
