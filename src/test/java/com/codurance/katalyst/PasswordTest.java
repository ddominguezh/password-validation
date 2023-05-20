package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordTest {
    
    @Test
    public void password_valid(){
        assertTrue(Password.create("aA1_alJld").isValid());
    }

    @Test
    public void the_password_is_wrong_if_it_does_not_have_more_than_eight_characters(){
        assertFalse(Password.create("aA1_94sÑ").isValid());
    }

}
