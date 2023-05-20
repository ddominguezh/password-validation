package com.codurance.katalyst;

import java.util.ArrayList;
import java.util.List;

import com.codurance.katalyst.rules.MinLengthPasswordRule;
import com.codurance.katalyst.rules.PasswordRule;
import com.codurance.katalyst.rules.SomeLowerCharacterPasswordRule;
import com.codurance.katalyst.rules.SomeNumberPasswordRule;
import com.codurance.katalyst.rules.SomeUnderscorePasswordRule;
import com.codurance.katalyst.rules.SomeUpperCharacterPasswordRule;

public class PasswordRulesBuilder {
    
    private List<PasswordRule> rules;
    public PasswordRulesBuilder(){
        this.rules = new ArrayList<PasswordRule>();
    }
    public PasswordRulesBuilder minLenght(int minLength){
        this.rules.add(new MinLengthPasswordRule(minLength));
        return this;
    }
    public PasswordRulesBuilder someNumber(){
        this.rules.add(new SomeNumberPasswordRule());
        return this;
    }
    public PasswordRulesBuilder someUnderscore(){
        this.rules.add(new SomeUnderscorePasswordRule());
        return this;
    }
    public PasswordRulesBuilder someLowerCharacter(){
        this.rules.add(new SomeLowerCharacterPasswordRule());
        return this;
    }
    public PasswordRulesBuilder someUpperCharacter(){
        this.rules.add(new SomeUpperCharacterPasswordRule());
        return this;
    }
    public List<PasswordRule> build(){
        return rules;
    }
}
