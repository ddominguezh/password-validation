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
        if(this.value.length() <= 8){
            return false;
        }
        if(!this.value.contains("_")){
            return false;
        }
        return true;
    }
    
}
