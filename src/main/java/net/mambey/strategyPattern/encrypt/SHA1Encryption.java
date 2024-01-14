package net.mambey.strategyPattern.encrypt;

import net.mambey.strategyPattern.enums.EncodingPatternEnum;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class SHA1Encryption implements Encryption{
    @Override
    public String encrypt(String textToHash) {

        String result = null;
        try {
            result = generateSHA1Hash(textToHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public EncodingPatternEnum getEncryptionPattern() {
        return EncodingPatternEnum.SHA1;
    }

    private static String generateSHA1Hash(String text) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        sha1.update(text.getBytes());
        byte[] digest = sha1.digest();

        // Convert the byte array to a hexadecimal string
        StringBuilder result = new StringBuilder();
        for (byte b : digest) {
            result.append(String.format("%02x", b));
        }

        return result.toString();
    }
}
