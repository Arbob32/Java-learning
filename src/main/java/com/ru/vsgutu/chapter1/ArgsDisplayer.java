package com.ru.vsgutu.chapter1;

public class ArgsDisplayer {
    public static void displayRevertArgs(final String args[]) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}
