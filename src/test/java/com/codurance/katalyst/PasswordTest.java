package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordTest {
    
    @Test
    public void password_valid(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(8)
                .someUnderscore()
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("aA1_alJld"));
        assertEquals(0, password.errors().size());
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_more_than_eight_characters(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(8)
                .someUnderscore()
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("aA1_94sÑ"));
        assertEquals(1, password.errors().size());
        assertEquals("Must be more than 8 characters", password.errors().get(0));
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_underscore(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(8)
                .someUnderscore()
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("aA1OalJld"));
        assertEquals(1, password.errors().size());
        assertEquals("Must contain some underscore", password.errors().get(0));
    }


    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_number(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(8)
                .someUnderscore()
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("aAU_alJld"));
        assertEquals(1, password.errors().size());
        assertEquals("Must contain some number", password.errors().get(0));
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_upper_character(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(8)
                .someUnderscore()
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("aa1_al4ld"));
        assertEquals(1, password.errors().size());
        assertEquals("Must contain some upper character", password.errors().get(0));
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_some_lower_character(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(8)
                .someUnderscore()
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("8A1_ZKJ_9"));
        assertEquals(1, password.errors().size());
        assertEquals("Must contain some lower character", password.errors().get(0));
    }

    @Test
    public void the_password_contains_length_greather_that_six_some_number_some_upper_and_some_lower_character(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(6)
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("8A1ZKj9"));
        assertEquals(0, password.errors().size());
    }

    @Test
    public void the_password_contains_length_greather_that_sixteen_some_underscore_some_upper_and_some_lower_character(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(16)
                .someUnderscore()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertTrue(password.isValid("AZKj_diLDiw_djeO_"));
        assertEquals(0, password.errors().size());
    }

    @Test
    public void password_is_not_valid_when_have_two_or_more_errors(){
        Password password = Password.create(
            new PasswordRulesBuilder()
                .minLenght(6)
                .someNumber()
                .someUpperCharacter()
                .someLowerCharacter()
                .build()
        );
        assertFalse(password.isValid("jlkjlkdjslkj"));
        assertEquals(2, password.errors().size());
        assertEquals("Must contain some number", password.errors().get(0));
        assertEquals("Must contain some upper character", password.errors().get(1));
    }
}
