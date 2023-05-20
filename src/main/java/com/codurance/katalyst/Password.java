package com.codurance.katalyst;

public class Password {

    private String value;
    protected Password(String value){
        this.value = value;
    }
    public static Password create(String value) {
        return new Password(value);
    }
    public boolean isValid() {
        throw new UnsupportedOperationException();
    }
    
}
