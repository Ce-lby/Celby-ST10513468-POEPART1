/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog.part1;

import java.util.Scanner;

/**
 *
 * @author Celby
 */

public class PROGPART1 {

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        
        String userName = " ";
        String password;
        String cellNum;
        String firstName = " ";
        String lastName = " ";
        String loginPass = " " ;
        String loginUserName = " ";

        // Prompt user for name details
        System.out.print("Please enter your first name: ");
        firstName = myInput.nextLine();
        
        System.out.print("Please enter your last name: ");
        lastName = myInput.nextLine();

        Login login = new Login(firstName, lastName);

        // Prompt and validate username
        System.out.print("Enter your username: ");
        userName = myInput.nextLine();

        while (!login.checkUserName(userName)) {
            System.out.println("User name not correctly formatted");
            System.out.println("Please ensure that your username contains an underscore and is no more than 5 characters long.");
            System.out.print("Please re-enter your username: ");
            userName = myInput.nextLine();
        }
        System.out.println("Username successfully captured");

        // Prompt and validate password
        System.out.print("Enter your password: ");
        password = myInput.nextLine();

        while (!login.checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted.");
            System.out.println("Please ensure that the password contains:");
            System.out.println("- At least eight characters");
            System.out.println("- A capital letter");
            System.out.println("- A number");
            System.out.println("- A special character");

            System.out.print("Re-enter your password: ");
            password = myInput.nextLine();
        }
        System.out.println("Password successfully captured");

        // Register user credentials
        login.registerUser(userName, password);

        // Prompt and validate cell phone number
        System.out.print("Enter your cellphone number: ");
        cellNum = myInput.nextLine();

        while (!login.checkCellPhoneNumber(cellNum)) {
            System.out.println("Cell phone number incorrectly formatted.");
            System.out.print("Please re-enter your cellphone number (+27...): ");
            cellNum = myInput.nextLine();
        }
        System.out.println("Cell phone number successfully added");

        // Login prompt
        //prompt their username
        System.out.print("Enter your username to login: ");
        loginUserName = myInput.nextLine();
        
        //prompting the user to enter their password
        System.out.print("Enter your login password: ");
        loginPass = myInput.nextLine();
        
        //a amethod to check the users login status

        boolean status = login.loginUser(loginUserName, loginPass);
        if (status) {
            System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
        } else {
            System.out.println("Login failed. Please try again.");
        } 
        

        // QuickChat Application
        if (status) {
            System.out.println("\nWelcome to QuickChat.");

            boolean keepRunning = true;
            int totalMessagesSent = 0;

            while (keepRunning) {
                System.out.println("\nPlease choose an option from the menu:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Enter your choice (1-3 or 'quit'): ");

                String menuChoice = myInput.nextLine().trim();

                if (menuChoice.equalsIgnoreCase("quit") || menuChoice.equals("3")) {
                    System.out.println("Exiting QuickChat. Total messages processed: " + totalMessagesSent);
                    keepRunning = false;
                    break;
                }

                switch (menuChoice) {
                    case "1":
                        System.out.print("How many messages do you wish to enter? ");
                        int numMessages = myInput.nextInt();
                        myInput.nextLine(); 

                        for (int i = 0; i < numMessages; i++) {
                            System.out.println("\n--- Enter Message " + (i + 1) + " of " + numMessages + " ---");

                            System.out.print("Enter recipient cell number: ");
                            String recipient = myInput.nextLine();

                            System.out.print("Enter your message (max 250 characters): ");
                            String messageText = myInput.nextLine();

                            Messages msg = new Messages(i + 1, recipient, messageText);

                            // Validate message length
                            if (!msg.checkMessageLength()) {
                                System.out.println("Error: Please enter a message of 250 characters or less. Skipping this message.");
                                continue; 
                            }

                            // Choose action
                            System.out.println("Select an action for this message:");
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message to send later");
                            System.out.print("Choice: ");
                            String action = myInput.nextLine().trim();

                            String resultMessage = msg.SentMessage(action);
                            System.out.println(resultMessage);

                            if (action.equals("1")) {
                                totalMessagesSent++;
                                System.out.println(msg.printMessage());
                            } else if (action.equals("3")) {
                                System.out.println("JSON Record:\n" + msg.storeMessage());
                            }
                        }
                        System.out.println("Total messages sent so far: " + Messages.returnTotalMessages());
                        break;

                    case "2":
                        Messages temp = new Messages();
                        System.out.println(temp.printMessages());
                        break;

                    default:
                        System.out.println("Invalid option. Please select 1, 2, or 3.");
                }
            }
        } else {
            System.out.println("Access Denied. You must login successfully to QuickChat.");
        }

       
    }

    
    public boolean checkUserName(String userName) {
        Login testLogin = new Login("", "");
        return testLogin.checkUserName(userName);
    }

    public boolean checkPasswordComplexity(String password) {
        Login testLogin = new Login("", "");
        return testLogin.checkPasswordComplexity(password);
    }

    public boolean loginUser(String username, String password, String loginStatus) {
        Login testLogin = new Login("", "");
        return testLogin.loginUser(username, password);
    }

    public static boolean checkCellPhoneNumber(String cellNum) {
        Login testLogin = new Login("", "");
        return testLogin.checkCellPhoneNumber(cellNum);
    }
}