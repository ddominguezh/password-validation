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
        assertTrue(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(8)
                    .someUnderscore()
                    .someNumber()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("aA1_alJld")
        );
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_more_than_eight_characters(){
        assertFalse(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(8)
                    .someUnderscore()
                    .someNumber()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("aA1_94sÑ")
        );
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_underscore(){
        assertFalse(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(8)
                    .someUnderscore()
                    .someNumber()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("aA1OalJld")
        );
    }


    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_number(){
        assertFalse(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(8)
                    .someUnderscore()
                    .someNumber()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("aAU_alJld")
        );
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_upper_character(){
        assertFalse(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(8)
                    .someUnderscore()
                    .someNumber()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("aa1_al4ld")
        );
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_lower_character(){
        assertFalse(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(8)
                    .someUnderscore()
                    .someNumber()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("8A1_ZKJ_9")
        );
    }

    @Test
    public void the_password_contains_length_greather_that_six_some_number_some_upper_and_some_lower_character(){
        assertTrue(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(6)
                    .someNumber()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("8A1ZKj9")
        );
    }

    @Test
    public void the_password_contains_length_greather_that_sixteen_some_underscore_some_upper_and_some_lower_character(){
        assertTrue(
            Password.create(
                new PasswordRulesBuilder()
                    .minLenght(16)
                    .someUnderscore()
                    .someUpperCharacter()
                    .someLowerCharacter()
                    .build()
            )
            .isValid("AZKj_diLDiw_djeO_")
        );
    }
}
