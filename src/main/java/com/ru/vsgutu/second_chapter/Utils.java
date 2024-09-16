package com.ru.vsgutu.second_chapter.variant_a;

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
}
