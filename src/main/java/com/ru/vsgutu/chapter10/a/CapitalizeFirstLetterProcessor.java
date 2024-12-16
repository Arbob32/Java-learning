package com.ru.vsgutu.chapter10.a;

import com.ru.vsgutu.chapter10.FileProcessor;

// В каждом слове повести Владимира Короткевича «Дикая охота короля
// Стаха» заменить первую букву слова на прописную.
public class CapitalizeFirstLetterProcessor extends FileProcessor {
    public CapitalizeFirstLetterProcessor(String inputFilePath, String outputDirPath) {
        super(inputFilePath, outputDirPath, "processed_file.txt");
    }

    @Override
    protected String processLine(String line) {
        StringBuilder result = new StringBuilder();
        String[] words = line.split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1));
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
