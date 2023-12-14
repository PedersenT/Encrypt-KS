package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {

    public void writeTofile(String[] strArray, Path path) throws IOException {
        Files.write(path, String.join("\n", strArray).getBytes());
    }
}
