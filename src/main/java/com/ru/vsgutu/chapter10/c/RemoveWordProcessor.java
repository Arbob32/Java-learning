package com.ru.vsgutu.chapter10.c;

import com.ru.vsgutu.chapter10.FileProcessor;
import java.util.ArrayList;
import java.util.List;

// Из файла удалить все слова, содержащие от трех до пяти символов, но при
// этом из каждой строки должно быть удалено только максимальное четное
// количество таких слов.
public class RemoveWordProcessor extends FileProcessor {
    public RemoveWordProcessor(String inputFilePath, String outputDirPath) {
        super(inputFilePath, outputDirPath, "processed_file.txt");
    }

    @Override
    protected String processLine(String line) {
        String[] words = line.split(" ");
        List<String> resultWords = new ArrayList<>();
        int countToRemove = 0;

        for (String word : words) {
            if (word.length() >= 3 && word.length() <= 5) {
                countToRemove++;
            }
        }

        countToRemove = (countToRemove / 2) * 2;

        for (String word : words) {
            if (countToRemove > 0 && word.length() >= 3 && word.length() <= 5) {
                countToRemove--;
            } else {
                resultWords.add(word);
            }
        }

        return String.join(" ", resultWords);
    }
}
