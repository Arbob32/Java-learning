package com.ru.vsgutu.chapter9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FloatNumUtilsTest {

    @TempDir Path tempDir;

    @Test
    void readTest() throws Exception {
        File tempFile = tempDir.resolve("test.txt").toFile();
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("1234.56,en\n");
            writer.write("1234.56,fr\n");
        }

        List<Double> expected = Arrays.asList(1234.56, 1234.0);
        assertEquals(expected, FloatNumUtils.readFile(tempFile.getAbsolutePath()));
    }
}
