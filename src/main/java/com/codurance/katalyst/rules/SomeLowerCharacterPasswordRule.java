package com.codurance.katalyst.rules;

import java.util.regex.Pattern;

public class SomeLowerCharacterPasswordRule implements PasswordRule {
    
    @Override
    public boolean isWrong(String password) {
        return !Pattern.compile("[a-zñ]").matcher(password).find();
    }
    
}
