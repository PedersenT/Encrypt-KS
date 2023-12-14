package org.example;


public class Main {
    public static void main(String[] args) throws Exception{


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

        int encryptionCount = 5000;

        String outText = "";

        String[] words = text.split("\\G\\s+");

        Encryption encryption = new Encryption();

        String[] encryptedElements = encryption.encryptArray(words);

        System.out.println("\nEncrypted array:");
        for (String encryptedElement : encryptedElements) {
            System.out.println(encryptedElement);
        }

        // Decrypt each element
        String[] decryptedElements = encryption.decryptArray(encryptedElements);

        // Display the decrypted array
        System.out.println("\nDecrypted array:");
        for (String decryptedElement : decryptedElements) {
            System.out.println(decryptedElement);
        }
    }


}