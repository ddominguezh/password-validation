package com.codurance.katalyst;

import java.util.regex.Pattern;

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
        if(!Pattern.compile("\\d").matcher(this.value).find()){
            return false;
        }
        if(!Pattern.compile("[A-ZÑ]").matcher(this.value).find()){
            return false;
        }
        return true;
    }
    
}
