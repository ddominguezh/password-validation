package com.codurance.katalyst;

import java.util.List;
import java.util.regex.Pattern;

import com.codurance.katalyst.rules.MinLengthPasswordRule;
import com.codurance.katalyst.rules.PasswordRule;
import com.codurance.katalyst.rules.SomeLowerCharacterPasswordRule;
import com.codurance.katalyst.rules.SomeNumberPasswordRule;
import com.codurance.katalyst.rules.SomeUnderscorePasswordRule;
import com.codurance.katalyst.rules.SomeUpperCharacterPasswordRule;

public class Password {

    private List<PasswordRule> rules;
    protected Password(List<PasswordRule> rules){
        this.rules = rules;
    }
    public static Password create(List<PasswordRule> rules) {
        return new Password(rules);
    }
    public boolean isValid(String password) {
        for(PasswordRule rule : this.rules){
            if(rule.isWrong(password)){
                return false;
            }
        }
        return true;
    }
    
}
