package net.mambey.strategyPattern.encrypt;

import net.mambey.strategyPattern.enums.EncodingPatternEnum;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class SHA2Encryption implements Encryption{
    @Override
    public String encrypt(String textToHash) {

        String result = null;
        try {
            result = generateSHA2Hash(textToHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public EncodingPatternEnum getEncryptionPattern() {
        return EncodingPatternEnum.SHA2;
    }

    private static String generateSHA2Hash(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        byte[] digest = md.digest();

        // Convert the byte array to a hexadecimal string
        StringBuilder result = new StringBuilder();
        for (byte b : digest) {
            result.append(String.format("%02x", b & 0xff));
        }

        return result.toString();
    }
}
