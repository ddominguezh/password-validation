package com.codurance.katalyst;

import java.util.List;

import com.codurance.katalyst.rules.PasswordRule;

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
