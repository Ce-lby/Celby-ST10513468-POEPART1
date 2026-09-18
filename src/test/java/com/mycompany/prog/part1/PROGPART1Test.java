/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog.part1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Celby
 */
public class PROGPART1Test {
    
    public PROGPART1Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    
    @Test
    public void testUserNameCorrect() {
        boolean result = PROGPART1.checkUserName("kyl_1");
        System.out.println(result ? 
            "Welcome Celby, it is great to see you." : 
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        assertTrue(result);
    }

    @Test
    public void testUserNameIncorrect() {
        boolean result = PROGPART1.checkUserName("kyle!!!!!!");
        System.out.println(result ? 
            "Welcome Celby, it is great to see you." : 
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        assertFalse(result);
    }

    
    @Test
    public void testPasswordCorrect() {
        boolean result = PROGPART1.checkPasswordComplexity("Ch&&sec@ke99!");
        System.out.println(result ? 
            "Password successfully captured." : 
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        assertTrue(result);
    }

    @Test
    public void testPasswordIncorrect() {
        boolean result = PROGPART1.checkPasswordComplexity("password");
        System.out.println(result ? 
            "Password successfully captured." : 
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        assertFalse(result);
    }

    
    @Test
    public void testCellPhoneCorrect() {
        boolean result = PROGPART1.checkCellPhoneNumber("+27838968976");
        System.out.println(result ? 
            "Cell number successfully captured." : 
            "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
        assertTrue(result);
    }

    @Test
    public void testCellPhoneIncorrect() {
        boolean result = PROGPART1.checkCellPhoneNumber("08966553");
        System.out.println(result ? 
            "Cell number successfully captured." : 
            "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
        assertFalse(result);
    }

    
    @Test
    public void testLoginSuccess() {
        boolean result = PROGPART1.loginUser("user_1", "Pass@123", "user_1", "Pass@123");
        System.out.println(result ? "Login Successful" : "Login Failed");
        assertTrue(result);
    }

    @Test
    public void testLoginFail() {
        boolean result = PROGPART1.loginUser("user_1", "wrongPass", "user_1", "Pass@123");
        System.out.println(result ? "Login Successful" : "Login Failed");
        assertFalse(result);
    }
}
