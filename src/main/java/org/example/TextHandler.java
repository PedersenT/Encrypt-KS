package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextHandler {

    public String[] convertToArray(String text){

        // Split the text into lines
        String[] lines = text.split("\n");

        // Initialize a list to store words along with line breaks
        List<String> wordsWithLineBreaks = new ArrayList<>();

        // Split each line into words and add them to the list
        for (String line : lines) {
            String[] wordsInLine = line.split("\\s+");
            wordsWithLineBreaks.addAll(Arrays.asList(wordsInLine));
        }
        // Convert the list to an array
        return wordsWithLineBreaks.toArray(new String[0]);

    }
}
