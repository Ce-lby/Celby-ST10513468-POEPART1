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
            
            
            //promting the user to enter thier cellphone number
            System.out.print("Enter your cellphone number: ");
            cellNum = myInput.nextLine();
            
            //validate the user to enter their cellphone number
            while (!checkCellPhoneNumber (cellNum)){
        System.out.println("Cell phone number incorrectly formatted");
        System.out.print("Cellphone number does not contain international code");
        
        System.out.print("Please re-enter your cell phone number: ");
        cellNum = myInput.nextLine();
        
    }
            System.out.print("Cell phone number successfully added");
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
    //a method to check if the cell phone number's conditions are met
    public static boolean checkCellPhoneNumber (String cellNum){
        //if statement to check the cell phones conditions
        if (cellNum.startsWith("+27") && cellNum.length() == 12){
            return true;
        }
        return false;
    }
    }
        
    
    
     
    
    
    
    
    
       

   
    
    



       
         


