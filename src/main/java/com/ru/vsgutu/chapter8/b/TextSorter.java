package com.ru.vsgutu.chapter8.b;

import java.util.*;

// 7. Рассортировать слова текста по возрастанию доли гласных букв (отноше-
// ние количества гласных к общему количеству букв в слове)
public class TextSorter {
    public String sortWordByVowelRatio(String text) {
        String[] words = text.split("\\W+");

        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        wordList.sort(Comparator.comparingDouble(TextSorter::getVowelRatio));

        return String.join(" ", wordList);
    }

    private static double getVowelRatio(String word) {
        String vowels = "aeiouAEIOU";
        int vowelCount = 0;

        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelCount++;
            }
        }

        return !word.isEmpty() ? (double) vowelCount / word.length() : 0;
    }
}
