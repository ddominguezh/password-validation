package com.codurance.katalyst.rules;

import java.util.regex.Pattern;

public class SomeNumberPasswordRule implements PasswordRule {
    
    @Override
    public boolean isWrong(String password) {
        return !Pattern.compile("\\d").matcher(password).find();
    }

    @Override
    public String message() {
        return "Must contain some number";
    }

}
