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
             
        }
    //QuickChat
    
    //decalrations 
    String Message;
    public static void runQuickChat(Scanner myInput){
        System.out.println("Welcome to QuickChat");
        
        System.out.print("How many messages would you like to enter? ");
        int numMessages = myInput.nextInt();
        
        List <Message> messages = new ArrayList<>();
        
        boolean running = true;
        while (running){
            System.out.println("Choose an option: ");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            
            int choice = myInput.nextInt();
            
            switch (choice) {
                case 1: 
                    for (int i = 0; i < numMessages; i++) {
                        System.out.println("Enter the recipients cell number: ");
                        String recipient = myInput.nextLine();
                        
                        System.out.println("Enter your message: ");
                        String txtMessage = myInput.nextLine();
                        
                        Message msg = new Message(recipient, txtMessage, i + 1);
                        System.out.print(msg.SentMessage(myInput));
                        messages.add(msg);
                        System.out.println(msg.printMessages());
                    }
                    System.out.println("Total messages sent: " + Message.retunTotalMessages());
                    break;
                    
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                    
                case 3:
                    running = false;
                    System.out.println("Exiting QuickChat...");
                    break;
                    
                default :
                    System.out.println("Invalid choice. Try again");
            }
        }
    } 
}
    
    

        
    
    
      
    
    
    
    
    
       

   
    
    



       
         
