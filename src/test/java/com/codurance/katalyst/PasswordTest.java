package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.codurance.katalyst.rules.MinLengthPasswordRule;
import com.codurance.katalyst.rules.PasswordRule;
import com.codurance.katalyst.rules.SomeLowerCharacterPasswordRule;
import com.codurance.katalyst.rules.SomeNumberPasswordRule;
import com.codurance.katalyst.rules.SomeUnderscorePasswordRule;
import com.codurance.katalyst.rules.SomeUpperCharacterPasswordRule;

public class PasswordTest {
    
    @Test
    public void password_valid(){
        assertTrue(Password.create(new ArrayList<PasswordRule>(){
            {
                add(new MinLengthPasswordRule(8));
                add(new SomeUnderscorePasswordRule());
                add(new SomeNumberPasswordRule());
                add(new SomeUpperCharacterPasswordRule());
                add(new SomeLowerCharacterPasswordRule());
            }
        }).isValid("aA1_alJld"));
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_more_than_eight_characters(){
        assertFalse(Password.create(new ArrayList<PasswordRule>(){
            {
                add(new MinLengthPasswordRule(8));
                add(new SomeUnderscorePasswordRule());
                add(new SomeNumberPasswordRule());
                add(new SomeUpperCharacterPasswordRule());
                add(new SomeLowerCharacterPasswordRule());
            }
        }).isValid("aA1_94sÑ"));
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_underscore(){
        assertFalse(Password.create(new ArrayList<PasswordRule>(){
            {
                add(new MinLengthPasswordRule(8));
                add(new SomeUnderscorePasswordRule());
                add(new SomeNumberPasswordRule());
                add(new SomeUpperCharacterPasswordRule());
                add(new SomeLowerCharacterPasswordRule());
            }
        }).isValid("aA1OalJld"));
    }


    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_number(){
        assertFalse(Password.create(new ArrayList<PasswordRule>(){
            {
                add(new MinLengthPasswordRule(8));
                add(new SomeUnderscorePasswordRule());
                add(new SomeNumberPasswordRule());
                add(new SomeUpperCharacterPasswordRule());
                add(new SomeLowerCharacterPasswordRule());
            }
        }).isValid("aAU_alJld"));
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_upper_character(){
        assertFalse(Password.create(new ArrayList<PasswordRule>(){
            {
                add(new MinLengthPasswordRule(8));
                add(new SomeUnderscorePasswordRule());
                add(new SomeNumberPasswordRule());
                add(new SomeUpperCharacterPasswordRule());
                add(new SomeLowerCharacterPasswordRule());
            }
        }).isValid("aa1_al4ld"));
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_lower_character(){
        assertFalse(Password.create(new ArrayList<PasswordRule>(){
            {
                add(new MinLengthPasswordRule(8));
                add(new SomeUnderscorePasswordRule());
                add(new SomeNumberPasswordRule());
                add(new SomeUpperCharacterPasswordRule());
                add(new SomeLowerCharacterPasswordRule());
            }
        }).isValid("8A1_ZKJ_9"));
    }

    @Test
    public void the_password_contains_length_greather_that_six_some_number_some_upper_and_some_lower_character(){
        assertTrue(Password.create(new ArrayList<PasswordRule>(){
            {
                add(new MinLengthPasswordRule(6));
                add(new SomeNumberPasswordRule());
                add(new SomeUpperCharacterPasswordRule());
                add(new SomeLowerCharacterPasswordRule());
            }
        }).isValid("8A1ZKj9"));
    }
}
