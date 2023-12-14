package org.example;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{

//        Encryption encryption = new Encryption();
        FileWriter fileWriter = new FileWriter();
        TextHandler textHandler = new TextHandler();
        CaesarEncryption caesarEncryption = new CaesarEncryption();
        Encryption encryption = new Encryption();

        String text = """
                Examples
                                
                A Non-programming Example
                                
                Suppose a simple scheme for a repair centre, involving a manager and a group of technicians.
                The manager is responsible for receiving articles, and assigning an article to be repaired by a
                technician. All technicians have similar skills for repairing articles, and each one is responsible
                to repair one article at a time, independent of the other technicians. When a technician finishes
                repairing his assignment, he notifies the manager; the manager then assigns him a new article
                to be repaired, and so on. In general, repairing articles represents an irregular problem: some
                articles may present a simple fix and take a little amount of time, while others may require a
                more complex repair. Also, the effectiveness of this scheme relies on the fact that the number of
                articles that arrive to the centre can be substantially larger than the number of technicians
                available.
                """;
        String[] words = textHandler.convertToArray(text);


        int encryptionCount = 5;


//        Caesar
//        String[] encryptedElements = caesarEncryption.encryptArray(words,encryptionCount);
//        // File path
//        Path path=Path.of("C:/Jobb/Intervju/KS/encrypted_output.txt");
//        // Write to file
//        fileWriter.writeTofile(encryptedElements, path);


//      Blowfish
        // Encrypt and save to array
        String[] encryptedElements = encryption.encryptArray(words, encryptionCount);
        System.out.println("\nEncrypted array:" + Arrays.toString(encryptedElements));

        // File path
        Path path=Path.of("C:/Jobb/Intervju/KS/encrypted_output.txt");

        // Write to file
        fileWriter.writeTofile(encryptedElements, path);

        // Decrypt from file
        String[] decryptedElements = encryption.decryptArray(fileWriter.readFromFile(path), encryptionCount);

        // Display the decrypted array
        System.out.println("\nDecrypted array:" + Arrays.toString(decryptedElements));





    }


}