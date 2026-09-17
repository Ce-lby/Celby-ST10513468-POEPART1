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
       
       System.out.print("Enter your username: ");
       userName = myInput.nextLine();
       //prompting the user to enter their user name
       while (!checkUserName (userName))
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
        while (!checkPasswordComplexity (password)){
        System.out.println("Passwrod is not correctly formatted ");
        System.out.println("Please ensure that the password contains:");
        System.out.println("-Atleast eight characters");
        System.out.println("-A capital letter");
        System.out.println("-A number");
        System.out.println("-A special charactyer");
        
        System.out.print("Re-enter your password: ");
        password = myInput.nextLine();
    }
            System.out.println("Password succesfully captured");
            myInput.close();
        } 
     //a method to cherck if the condition if the username is met
    public static boolean checkUserName (String userName){
        //check if the the username meets all the conditions required of the user to enter
            return userName.length() <= 5 && userName.contains("_");
            
            
        }
    //A method to check the passwords complexity
    public static boolean checkPasswordComplexity(String password){
        //declarations
        boolean containsUpperCase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;
        
        //if statement to check for the length of the password
        if (password.length() < 8 ){
            return false;
        }
        //for loop to check the characters 
        for(int i = 0; i < password.length(); i++){
            char character = password.charAt(i);
            
            if (Character.isUpperCase(character)){
                containsUpperCase = true;
            }else if(Character.isDigit(character)){
                containsDigit = true;
            }else if(!Character.isLetterOrDigit(character)){
                containsSpecialChar = true;
            }
            }
            //show the conditions when they're met
            return containsUpperCase && containsDigit && containsSpecialChar;
        }
    }
        
    
    
     
    
    
    
    
    
       

   
    
    



       
         


