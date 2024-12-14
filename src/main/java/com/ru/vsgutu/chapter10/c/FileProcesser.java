package com.ru.vsgutu.chapter10.c;

import com.ru.vsgutu.chapter9.CustomException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


// Из файла удалить все слова, содержащие от трех до пяти символов, но при
//этом из каждой строки должно быть удалено только максимальное четное
//количество таких слов.
public class FileProcesser {
    public static void processFile(String inputFilePath, String outputDirPath) throws CustomException {
        File outputDir = new File(outputDirPath);
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            throw new CustomException("Не удалось создать директорию: " + outputDirPath);
        }

        File outputFile = new File(outputDir, "processed_numbers.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String processedLine = removeWordsByLength(line, 3, 5);
                if (!processedLine.isEmpty()) {
                    bw.write(processedLine);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new CustomException("Ошибка обработки файла: " + e.getMessage());
        }
    }

    private static String removeWordsByLength(String line, int minLen, int maxLen) {
        String[] words = line.split(" ");
        List<String> resultWords = new ArrayList<>();
        int countToRemove = 0;

        for (String word : words) {
            if (word.length() >= minLen && word.length() <= maxLen) {
                countToRemove++;
            }
        }

        countToRemove = (countToRemove / 2) * 2;

        for (String word : words) {
            if (countToRemove > 0 && word.length() >= minLen && word.length() <= maxLen) {
                countToRemove--;
            } else {
                resultWords.add(word);
            }
        }

        return String.join(" ", resultWords);
    }
}
