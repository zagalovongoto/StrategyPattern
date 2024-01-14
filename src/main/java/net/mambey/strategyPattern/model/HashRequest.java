package net.mambey.strategyPattern.model;

import net.mambey.strategyPattern.enums.EncodingPatternEnum;

public class HashRequest {
    private EncodingPatternEnum label;
    private String textToHash;

    public HashRequest(EncodingPatternEnum label, String textToHash) {
        this.label = label;
        this.textToHash = textToHash;
    }

    public EncodingPatternEnum getLabel() {
        return label;
    }

    public void setLabel(EncodingPatternEnum label) {
        this.label = label;
    }

    public String getTextToHash() {
        return textToHash;
    }

    public void setTextToHash(String textToHash) {
        this.textToHash = textToHash;
    }
}
