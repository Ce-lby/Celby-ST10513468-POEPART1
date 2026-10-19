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
       //scanner 
       Scanner myInput = new Scanner (System.in);
       //declarations 
       String userName = " ";
       String password;
       String cellNum;
       String firstName = " ";
       String lastName = " ";
       String loginPass = " ";
       String loginUserName = " ";
       
       
       
       //propt the user to enter their firstname
       System.out.print("Please enter your first name: ");
       firstName = myInput.nextLine();
       //prompt the user to enter their second name
       System.out.print("Please enter your last name: ");
       lastName = myInput.nextLine();
       
       Login login = new Login(firstName, lastName);
       
       System.out.print("Enter your username: ");
       userName = myInput.nextLine();
       //prompting the user to enter their user name
       while (!login.checkUserName (userName))
       {
               System.out.println("Username successfully captured");
               System.out.println("User name not correctly formatted");
               System.out.println("Please ensure that your username contains an underscore");
               System.out.println ("Username must not be more than five characters in length");
               
               System.out.print("Please re-enter your username: ");
               userName = myInput.nextLine();
               
           }
                //when the correct details have been entered 
                System.out.println("Username successfully captured");
                
                //validate the user to enter their password
            System.out.print("Enter your password: ") ;
            password = myInput.nextLine();
            
            //prompt the user to enter their passwords
        while (!login.checkPasswordComplexity (password)){
        System.out.println("Passwrod is not correctly formatted ");
        System.out.println("Please ensure that the password contains:");
        System.out.println("-Atleast eight characters");
        System.out.println("-A capital letter");
        System.out.println("-A number");
        System.out.println("-A special character");
        
        System.out.print("Re-enter your password: ");
        password = myInput.nextLine();
    }
            System.out.println("Password succesfully captured");
            
            //register user credentials
            login.registerUser(userName, password);
            
            
            //promting the user to enter thier cellphone number
            System.out.print("Enter your cellphone number: ");
            cellNum = myInput.nextLine();
            
            //validate the user to enter their cellphone number
            while (!login.checkCellPhoneNumber (cellNum)){
        System.out.println("Cell phone number incorrectly formatted");
        System.out.print("Cellphone number does not contain international code");
        
        System.out.print("Please re-enter your cell phone number: ");
        cellNum = myInput.nextLine();
        
    }
            System.out.println("Cell phone number successfully added");
            
            //Login
           //promt the user to enter their login username
            System.out.println("Enter your username to login: ");
            loginUserName = myInput.nextLine();
            
            //prompting the user to enter their login password
            System.out.println("Enter your login password: ");
            loginPass = myInput.nextLine();
            
            //a method to check the users login status 
            boolean status = login.loginUser(loginUserName, loginPass);
            if (status){
                System.out.println("Welcome" + firstName + " " + lastName + " , it is great to see you again");
            }else {
                System.out.println("Login failed. Please try again");
            }   
            //QuickChat
            if (status) {
                System.out.print("Welcome to QuickChat.");
                
                boolean keepRunning = true;
                int totalMessagesSent = 0;
                
                while (keepRunning) {
                    System.out.println("Please choose an option from the menu: ");
                    System.out.println("1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Quit");
                    System.out.println("Enter your choice (1-3 or 'quit'): ");
                    
                    String menuChoice = myInput.nextLine().trim();
                    
                    if (menuChoice.equalsIgnoreCase("quit") || menuChoice.equals("3")) {
                        System.out.println("Exiting QuickChat. Total messages processed: " + totalMessagesSent);
                        keepRunning = false;
                        break;
                    }
                    
                    switch (menuChoice) {
                        case "1":
                            System.out.print("How many messages do you wish ro enter? ");
                            int numMessages = myInput.nextInt();
                            myInput.nextLine();
                            
                            for (int i = 0; i < numMessages; i++){
                                System.out.println("Enter Message" + (i + 1) + "of" + numMessages + "---");
                                
                                System.out.print("Enter recipient cell number: ");
                                String recipient = myInput.nextLine();
                                
                                System.out.print("Enter your message (max 250 characters): ");
                                String messageText = myInput.nextLine();
                                
                                Messages msg = new Messages(i, recipient, messageText);
                                
                                //message length
                                if (!msg.checkMessageLength()){
                                    System.out.println("Please enter a message of less than 250 characters.");
                                    return;
                                }
                                //message action
                                System.out.println("Select an action for this message");
                                System.out.println("1) Send Message");
                                System.out.println("0) Disregard Message");
                                System.out.println("2) Store Message to send later");
                                System.out.print("Choice: ");
                                String action = myInput.nextLine().trim();
                                
                                String resultMessage = msg.SentMessage(action);
                                System.out.println(resultMessage);
                                
                                if (action.equals("1")){
                                    totalMessagesSent++;
                                    System.out.println(msg.printMessages());
                                    
                                }else if (action.equals("2")) {
                                    System.out.println("JSON Record:" + msg.storeMessage());
                                }
                            }
                            System.out.println("Total messages successfully sent: " + totalMessagesSent);
                            break;
                            
                        case "2":
                            System.out.println("Coming Soon.");
                            break;
                            
                        default:
                            System.out.println("Invalid option. Please select 1, 2, or 3");
                    }
                }
            }else {
                System.out.println("Access Denied. You must login successfully to QuickChat.");
            }
            myInput.close();
        }
    
}
    
    

        
    
    
      
    
    
    
    
    
       

   
    
    



       
         
