package com.codurance.katalyst;

import java.util.regex.Pattern;

import com.codurance.katalyst.rules.MinLengthPasswordRule;
import com.codurance.katalyst.rules.SomeLowerCharacterPasswordRule;
import com.codurance.katalyst.rules.SomeNumberPasswordRule;
import com.codurance.katalyst.rules.SomeUnderscorePasswordRule;
import com.codurance.katalyst.rules.SomeUpperCharacterPasswordRule;

public class Password {

    private String value;
    protected Password(String value){
        this.value = value;
    }
    public static Password create(String value) {
        return new Password(value);
    }
    public boolean isValid() {
        if(new MinLengthPasswordRule(8).isWrong(value)){
            return false;
        }
        if(new SomeUnderscorePasswordRule().isWrong(value)){
            return false;
        }
        if(new SomeNumberPasswordRule().isWrong(value)){
            return false;
        }
        if(new SomeUpperCharacterPasswordRule().isWrong(value)){
            return false;
        }
        if(new SomeLowerCharacterPasswordRule().isWrong(value)){
            return false;
        }
        return true;
    }
    
}
