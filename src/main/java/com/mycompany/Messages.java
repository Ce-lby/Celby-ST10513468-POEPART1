/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author Celby
 */
public class Messages {
    
    //message variables declarstions 
    private String messageID;
    private int messageNum;
    private String recipient;
    private String message;
    private String messageHash;
    private String messageStatus;
    private static int totalMessages = 0;
    
    //a method to check the messade ID length
    public boolean checkMessageID(String messageID){
        if (messageID.length() <= 10){
            return true;
        }else {
            return false;
        }
    }
    
    //a method to check if the recipient cell number's length and if it starts with a code
    public boolean checkRecipientCell (String recipient){
        if (recipient.length() <= 10 && recipient.startsWith("+27")){
            return true;
        }else {
            return false;
        }
    }
    
    //a method to create a message hash 
    public boolean createMessageHash(int numMessages) {
        String words = message.split(" ");
        String 
    }
    
    
    
}
