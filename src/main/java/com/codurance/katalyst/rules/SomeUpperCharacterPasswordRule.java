package com.codurance.katalyst.rules;

import java.util.regex.Pattern;

public class SomeUpperCharacterPasswordRule implements PasswordRule {
    
    @Override
    public boolean isWrong(String password) {
        return !Pattern.compile("[A-ZÑ]").matcher(password).find();
    }
    
    @Override
    public String message() {
        return "Must contain some upper character";
    }

}
