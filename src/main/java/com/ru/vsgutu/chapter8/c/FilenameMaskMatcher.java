package com.ru.vsgutu.chapter8.c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilenameMaskMatcher {
    public static boolean match(String filename, String mask) {
        String regex = mask
                .replace(".", "\\.")
                .replace("?", ".")
                .replace("*", ".*");

        Pattern pattern = Pattern.compile("^" + regex + "$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(filename);

        return matcher.matches();
    }

}