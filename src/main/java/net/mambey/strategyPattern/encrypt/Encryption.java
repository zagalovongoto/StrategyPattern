package net.mambey.strategyPattern.encrypt;

import net.mambey.strategyPattern.enums.EncodingPatternEnum;

public interface Encryption {
    public String encrypt(String toeEncrypted);
    public EncodingPatternEnum getEncryptionPattern();
}
