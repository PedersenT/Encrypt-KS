package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Encryption {

    public SecretKey secretKey;

    public Encryption() throws Exception {
        secretKey=generateSecretKey();
    }

    private SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Use 256-bit key size for AES
        return keyGenerator.generateKey();
    }

    public String[] encryptArray(String[] array, int encryptionCount) throws Exception {
        String[] encryptedArray = array.clone();
        for(int j=0; j<encryptionCount; j++){
            for (int i = 0; i < array.length; i++) {
                encryptedArray[i] = encryptString(encryptedArray[i], secretKey);

            }
            System.out.println(j + " " + Arrays.toString(encryptedArray));
        }

        return encryptedArray;
    }

    private  String encryptString(String input, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String[] decryptArray(String[] array, int encryptionCount) throws Exception {
        String[] decryptedArray = array.clone();

        for(int j=0; j<encryptionCount; j++){
            for (int i = 0; i < array.length; i++) {
                decryptedArray[i] = decryptString(decryptedArray[i], secretKey);
            }
        }
        return decryptedArray;
    }
    private String decryptString(String encryptedInput, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedInput);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }




}
