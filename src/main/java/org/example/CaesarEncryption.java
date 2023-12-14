package org.example;


public class CaesarEncryption {
    private final int shift;

    public CaesarEncryption() {
        this.shift = 10;
    }

    public String[] encryptArray(String[] array, int encryptionCount) {
        String[] encryptedArray = array.clone();
        for (int j = 0; j < encryptionCount; j++) {
            for (int i = 0; i < array.length; i++) {
                encryptedArray[i] = encryptString(encryptedArray[i], shift);
            }
        }
        return encryptedArray;
    }

    private String encryptString(String input, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }


}
