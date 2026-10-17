/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog.part1;

/**
 *
 * @author Celby
 */
public class Login {
      // Variables to store the registered user's details
    private String registeredUserName;
    private String registeredPassword;
    private String firstName;
    private String lastName;

    // Constructor
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check if the username is correctly formatted
    public boolean checkUserName(String userName) {
        return userName.length() <= 5
                && userName.contains("_");
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        boolean containsUpperCase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                containsUpperCase = true;
            } else if (Character.isDigit(character)) {
                containsDigit = true;
            } else if (!Character.isLetterOrDigit(character)) {
                containsSpecialChar = true;
            }
        }

        return containsUpperCase
                && containsDigit
                && containsSpecialChar;
    }

    // Method to check cellphone number format
    public boolean checkCellPhoneNumber(String cellNum) {
        return cellNum.startsWith("+27")
                && cellNum.length() == 12;

    }

    // Method to register the user
    public String registerUser(String userName, String password) {

        if (!checkUserName(userName)) {
            return "Username is not correctly formatted. "
                    + "Please ensure that your username contains "
                    + "an underscore and is no more than five "
                    + "characters long.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. "
                    + "Please ensure that the password contains "
                    + "at least eight characters, a capital letter, "
                    + "a number and a special character.";
        }

        registeredUserName = userName;
        registeredPassword = password;

        return "Username and password successfully captured.";
    }

    // Method to verify the login details
    public boolean loginUser(String loginUserName,
                             String loginPass) {

        return registeredUserName != null
                && registeredPassword != null
                && loginUserName.equals(registeredUserName)
                && loginPass.equals(registeredPassword);
    }

    // Method to return the login status message
    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, " + "please try again.";
        }
    }
           
}

