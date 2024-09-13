package com.ru.vsgutu.first_chapter;

import java.util.Scanner;

public class Greeter {
    public static void scanNameAndGreetings() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println(String.format("Hello %s!", name));
    }
}
