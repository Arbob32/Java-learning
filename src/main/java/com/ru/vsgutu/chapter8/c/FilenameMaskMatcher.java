package com.ru.vsgutu.chapter8.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 7. Определить, удовлетворяет ли имя файла маске. Маска может содержать
// символы «?» (произвольный символ) и «*» (произвольное количество про-
// извольных символов).
public class FilenameMaskMatcher {
    public static boolean match(String filename, String mask) {
        String regex = mask.replace(".", "\\.").replace("?", ".").replace("*", ".*");

        Pattern pattern = Pattern.compile("^" + regex + "$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(filename);

        return matcher.matches();
    }
}
