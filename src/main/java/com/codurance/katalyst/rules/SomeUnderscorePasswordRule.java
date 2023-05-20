package com.codurance.katalyst.rules;

public class SomeUnderscorePasswordRule implements PasswordRule {

    @Override
    public boolean isWrong(String password) {
        return !password.contains("_");
    }
    
}
