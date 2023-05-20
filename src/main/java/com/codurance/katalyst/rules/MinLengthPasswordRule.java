package com.codurance.katalyst.rules;

public class MinLengthPasswordRule implements PasswordRule {

    private int minLength;
    public MinLengthPasswordRule(int minLength){
        this.minLength = minLength;
    }
    @Override
    public boolean isWrong(String password) {
        return password.length() <= this.minLength;
    }
    
}
