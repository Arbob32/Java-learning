package com.ru.vsgutu.chapter8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ru.vsgutu.chapter8.b.TextSorter;
import org.junit.jupiter.api.Test;

public class TextSorterTest {
    @Test
    void testSortWords() {
        String input = "test sorting sort";
        String expected = "test sort sorting";
        assertEquals(expected, new TextSorter().sortWordByVowelRatio(input));
    }
}
