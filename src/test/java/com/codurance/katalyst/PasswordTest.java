package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordTest {
    
    @Test
    public void password_valid(){
        assertTrue(Password.create("aA1_alJld").isValid());
    }

}
