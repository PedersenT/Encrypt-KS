package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriter {

    public void writeTofile(String[] strArray, Path path) throws IOException {
        Files.write(path, String.join("\n", strArray).getBytes());
    }

    public  String[] readFromFile(Path path) throws IOException {
        List<String> encryptedLines = Files.readAllLines(path);
        return encryptedLines.toArray(new String[0]);
    }

}
