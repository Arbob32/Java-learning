package com.ru.vsgutu.chapter9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class FloatNumUtils {

    private FloatNumUtils() {}

    public static List<Double> readFile(String fileName) throws CustomException {
        List<Double> nums = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.trim().split(",");
                    if (parts.length != 2) {
                        System.err.println("Некорректный формат записи: " + line);
                        continue;
                    }
                    double n = parseNumber(parts[0].trim(), parts[1].trim());
                    nums.add(n);
                } catch (NumberFormatException | ParseException e) {
                    System.err.println("Некорректная запись в файле: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new CustomException("Файл не найден: " + fileName);
        } catch (IOException e) {
            throw new CustomException("Ошибка при чтении файла: " + e.getMessage());
        }

        return nums;
    }

    public static double parseNumber(String numStr, String localeStr)
            throws NumberFormatException, ParseException {
        Locale locale;
        switch (localeStr) {
            case "en":
                locale = Locale.US;
                break;
            case "fr":
                locale = Locale.FRANCE;
                break;
            case "de":
                locale = Locale.GERMANY;
                break;
            case "es":
                locale = new Locale("es", "ES");
                break;
            case "it":
                locale = Locale.ITALY;
                break;
            case "ru":
                locale = new Locale("ru", "RU");
                break;
            default:
                throw new IllegalArgumentException("Неизвестная локаль: " + localeStr);
        }
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(numStr).doubleValue();
    }

    public static double calculateSum(List<Double> nums) {
        double sum = 0.0;
        for (double n : nums) {
            sum += n;
        }
        return sum;
    }
}
