package net.mambey.strategyPattern.controller;

import net.mambey.strategyPattern.enums.EncodingPatternEnum;
import net.mambey.strategyPattern.factory.EncryptionFactory;
import net.mambey.strategyPattern.model.HashRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StrategyDemoController {

    @Autowired
    EncryptionFactory encryptionFactory;
    @PostMapping("/encrypt")
    public String encryptWithEncoder(@RequestBody HashRequest hashRequest){

        return encryptionFactory.findEncryptionType(hashRequest.getLabel()).encrypt(hashRequest.getTextToHash());
    }

}
