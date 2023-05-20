package com.codurance.katalyst.rules;

public class LengthPasswordRule implements PasswordRule {

    private int minLength;
    public LengthPasswordRule(int minLength){
        this.minLength = minLength;
    }
    @Override
    public boolean isWrong(String password) {
        return password.length() <= this.minLength;
    }
    
}
