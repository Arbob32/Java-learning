package com.ru.vsgutu.chapter8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ru.vsgutu.chapter8.a.TextCleaner;
import org.junit.jupiter.api.Test;

class TextCleanerTest {

    @Test
    void testCleaner() {
        String input = "test?> !cleaner!!@";
        String expected = "test cleaner";
        assertEquals(expected, TextCleaner.clean(input));
    }
}
