package com.ru.vsgutu.second_chapter.b;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source base: ");
        int sourceBase = scanner.nextInt();

        System.out.println("Enter number: ");
        String number = scanner.next();

        System.out.println("Enter target base: ");
        int targetBase = scanner.nextInt();

        int decimal = Integer.parseInt(number, sourceBase);
        String target = Integer.toString(decimal, targetBase);

        System.out.println(target);
    }
}
