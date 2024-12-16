package com.ru.vsgutu.chapter10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ru.vsgutu.chapter10.a.CapitalizeFirstLetterProcessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FirstLetterProcessorTest {

    @TempDir Path tempDir;

    @Test
    void test() throws Exception {
        File inputFile = tempDir.resolve("input.txt").toFile();
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("test 1\n");
            writer.write("test test 2\n");
        }
        File outputDir = tempDir.resolve("output").toFile();
        CapitalizeFirstLetterProcessor processor =
                new CapitalizeFirstLetterProcessor(
                        inputFile.getAbsolutePath(), outputDir.getAbsolutePath());
        processor.processFile();
        File outputFile = new File(outputDir, "processed_file.txt");
        assertTrue(outputFile.exists());
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            assertEquals("Test 1", reader.readLine());
            assertEquals("Test Test 2", reader.readLine());
        }
    }
}
