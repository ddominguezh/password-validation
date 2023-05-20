package com.codurance.katalyst;

import java.util.ArrayList;
import java.util.List;

import com.codurance.katalyst.rules.PasswordRule;

public class Password {

    private List<PasswordRule> rules;
    private List<String> errors;
    protected Password(List<PasswordRule> rules, List<String> errors){
        this.rules = rules;
        this.errors = errors;
    }
    public static Password create(List<PasswordRule> rules) {
        return new Password(rules, new ArrayList<String>());
    }
    public boolean isValid(String password) {
        for(PasswordRule rule : this.rules){
            if(rule.isWrong(password)){
                errors.add(rule.message());
            }
        }
        return errors.size() <= 1;
    }
    public List<String> errors(){
        return this.errors;
    }
    
}
