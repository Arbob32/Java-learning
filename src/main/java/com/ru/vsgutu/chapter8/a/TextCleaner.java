package com.ru.vsgutu.chapter8.a;

// 7. Из текста удалить все символы, кроме пробелов, не являющиеся буквами. Между
// последовательностями подряд идущих букв оставить хотя бы один пробел
public class TextCleaner {
    public static String clean(String text) {
        String onlyLettersAndSpaces = text.replaceAll("[^a-zA-Zа-яА-Я\\s]", "");

        return onlyLettersAndSpaces.replaceAll("\\s+", " ").trim();
    }
}
