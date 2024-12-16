package com.ru.vsgutu.chapter8;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ru.vsgutu.chapter8.c.FilenameMaskMatcher;
import org.junit.jupiter.api.Test;

public class FilenameMaskMatcherTest {
    @Test
    void maskTest() {
        String filename = "example.txt";
        String mask = "*.txt";
        assertTrue(FilenameMaskMatcher.match(filename, mask));
    }
}
