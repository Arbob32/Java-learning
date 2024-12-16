package com.ru.vsgutu.chapter11;

import static org.junit.jupiter.api.Assertions.*;

import com.ru.vsgutu.chapter11.b.Matrix;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class MatrixTest {

    @TempDir Path tempDir;

    @Test
    void testAdd() throws IOException {
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        File matrix1File = tempDir.resolve("matrix1.txt").toFile();
        File matrix2File = tempDir.resolve("matrix2.txt").toFile();

        try (FileWriter writer = new FileWriter(matrix1File)) {
            writer.write("0 0 1\n1 1 2\n2 2 3\n");
        }
        try (FileWriter writer = new FileWriter(matrix2File)) {
            writer.write("0 0 4\n1 1 5\n2 2 6\n");
        }

        m1.readFromFile(matrix1File.getAbsolutePath());
        m2.readFromFile(matrix2File.getAbsolutePath());

        Matrix result = m1.add(m2);
        Matrix expected = new Matrix();
        File resultFile = tempDir.resolve("result_add.txt").toFile();

        try (FileWriter writer = new FileWriter(resultFile)) {
            writer.write("0 0 5\n1 1 7\n2 2 9\n");
        }

        expected.readFromFile(resultFile.getAbsolutePath());
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testMultiply() throws IOException {
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        File matrix3File = tempDir.resolve("matrix3.txt").toFile();
        File matrix4File = tempDir.resolve("matrix4.txt").toFile();

        try (FileWriter writer = new FileWriter(matrix3File)) {
            writer.write("0 0 1\n0 1 2\n1 0 3\n1 1 4\n");
        }

        try (FileWriter writer = new FileWriter(matrix4File)) {
            writer.write("0 0 5\n0 1 6\n1 0 7\n1 1 8\n");
        }

        m1.readFromFile(matrix3File.getAbsolutePath());
        m2.readFromFile(matrix4File.getAbsolutePath());

        Matrix result = m1.multiply(m2);
        Matrix expected = new Matrix();

        File resultFile = tempDir.resolve("result_multiply.txt").toFile();
        try (FileWriter writer = new FileWriter(resultFile)) {
            writer.write("0 0 19\n0 1 22\n1 0 43\n1 1 50\n");
        }

        expected.readFromFile(resultFile.getAbsolutePath());
        assertEquals(expected.toString(), result.toString());
    }
}
