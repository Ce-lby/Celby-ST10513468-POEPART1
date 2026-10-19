/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog.part1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PROGPART1Test {

    private Login login;

    @BeforeEach
    public void setUp() {
        // Login needs firstName and lastName
        login = new Login("Celby", "Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
    }

    @Test
    public void testUserNameCorrect() {
        boolean result = login.checkUserName("kyl_1");
        System.out.println(result ? "Welcome Celby, it is great to see you." : "Username is not correctly formatted");
        assertTrue(result);
    }

    @Test
    public void testUserNameIncorrect() {
        boolean result = login.checkUserName("kyle!!!!!!!");
        assertFalse(result);
    }

    @Test
    public void testPasswordCorrect() {
        boolean result = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testPasswordIncorrect() {
        boolean result = login.checkPasswordComplexity("Password");
        assertFalse(result);
    }

    @Test
    public void testCellPhoneCorrect() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }

    @Test
    public void testCellPhoneIncorrect() {
        boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse(result);
    }

    @Test
    public void testLoginSuccess() {
        // loginUser only takes 2 params: username and password
        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFail() {
        boolean result = login.loginUser("kyl_1", "wrongPass");
        assertFalse(result);
    }
}