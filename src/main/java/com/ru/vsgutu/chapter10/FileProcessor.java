package com.ru.vsgutu.chapter10;

import com.ru.vsgutu.chapter9.CustomException;
import java.io.*;

public abstract class FileProcessor {
    protected String inputFilePath;
    protected String outputDirPath;
    protected String outputFileName;

    public FileProcessor(String inputFilePath, String outputDirPath, String outputFileName) {
        this.inputFilePath = inputFilePath;
        this.outputDirPath = outputDirPath;
        this.outputFileName = outputFileName;
    }

    public void processFile() throws CustomException {
        File outputDir = new File(outputDirPath);
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            throw new CustomException("Не удалось создать директорию: " + outputDirPath);
        }

        File outputFile = new File(outputDir, outputFileName);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String processedLine = processLine(line);
                bw.write(processedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new CustomException("Ошибка обработки файла: " + e.getMessage());
        }
    }

    protected abstract String processLine(String line);
}
