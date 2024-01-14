package net.mambey.strategyPattern.factory;

import net.mambey.strategyPattern.encrypt.Encryption;
import net.mambey.strategyPattern.enums.EncodingPatternEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class EncryptionFactory {
    Map<EncodingPatternEnum, Encryption> map;

    @Autowired
    public EncryptionFactory(Set<Encryption> encryptionSet){
        createStrategy(encryptionSet);
    }

    private void createStrategy(Set<Encryption> encryptionSet){
        map = new HashMap<EncodingPatternEnum, Encryption>();
        encryptionSet.forEach(encryption -> {
            map.put(encryption.getEncryptionPattern(), encryption);
        });
    }
    public Encryption findEncryptionType(EncodingPatternEnum encodingPatternEnum){
        return map.get(encodingPatternEnum);
    }
}
