package com.ru.vsgutu.chapter2.b;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("   |");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%4d", i);
        }

        System.out.println("\n---+---------------------------------");

        for (int i = 2; i <= 9; i++) {
            System.out.printf("% d  |", i);
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
