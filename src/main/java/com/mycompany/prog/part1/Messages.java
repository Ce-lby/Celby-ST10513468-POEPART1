/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog.part1;

/**
 *
 * @author Celby
 */

   import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Messages  {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // shared by every message, so they are remembered while the program runs
    private static ArrayList<Messages> sentMessages = new ArrayList<>();
    private static ArrayList<Messages> storedMessages = new ArrayList<>();


    // Constructor to initialize message properties
    public Messages(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateRandomID();
        this.messageHash = createMessageHash();
    }

    // Helper to generate a random ten-digit ID
    private String generateRandomID() {
        Random rand = new Random();
        long id = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    // 1. checkMessageID(): ensures the message ID is not more than ten characters
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // 2. checkRecipientCell(): international code (+27) and no more than ten digits after it
    public String checkRecipientCell() {

        String wrong = "Cell number is incorrectly formatted or does not contain an international code; "
                + "please correct the number and try again.";

        if (recipient == null || !recipient.startsWith("+27") || recipient.length() <= 3 || recipient.length() > 13)
        {
            return wrong;
        }
        for (int i = 3; i < recipient.length(); i++)
        {
            if (!Character.isDigit(recipient.charAt(i)))
            {
                return wrong;
            }
        }
        return "Cell number successfully captured.";
    }

    // 3. createMessageHash(): first two ID digits : message number : first + last word (ALL CAPS)
    public String createMessageHash() {
        String firstTwoID = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;

        String firstWord = "";
        String lastWord = "";
        if (messageText != null && !messageText.trim().isEmpty())
        {
            String[] words = messageText.trim().split("\\s+");
            firstWord = words[0];
            lastWord = words[words.length - 1];
        }

        String combined = firstTwoID + ":" + messageNumber + ":" + firstWord + lastWord;
        return combined.toUpperCase();
    }

    // 4. SentMessage(): 1 = send, 2 = disregard, 3 = store
    public String SentMessage(String actionChoice) {

        if (actionChoice.equals("1"))
        {
            sentMessages.add(this);
            return "Message successfully sent";
        }
        else if (actionChoice.equals("2"))
        {
            return "Press 0 to delete the message";
        }
        else if (actionChoice.equals("3"))
        {
            storedMessages.add(this);
            storeMessage();
            return "Message successfully stored";
        }
        else
        {
            return "Invalid choice.";
        }
    }

    // 5. printMessages(): returns all the messages sent while the program is running
    public String printMessages() {

        if (sentMessages.isEmpty())
        {
            return "No messages have been sent yet.";
        }

        String all = "";
        for (int i = 0; i < sentMessages.size(); i++)
        {
            all = all + sentMessages.get(i).printMessage() + "\n";
        }
        return all;
    }

    // details of ONE message, in the order: ID, Hash, Recipient, Message
    public String printMessage() {
        return "----------------------------------------\n" +
               "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + messageText + "\n" +
               "----------------------------------------";
    }

    // 6. returnTotalMessagess(): returns the total number of messages sent
    public static int returnTotalMessagess() {
        return sentMessages.size();
    }

    // 7. storeMessage(): writes all stored messages to a JSON file and returns the JSON text
    public String storeMessage() {

        StringBuilder json = new StringBuilder();
        json.append("[\n");

        for (int i = 0; i < storedMessages.size(); i++)
        {
            Messages m = storedMessages.get(i);

            json.append("  {\n");
            json.append("    \"messageID\": \"").append(escapeJson(m.messageID)).append("\",\n");
            json.append("    \"messageHash\": \"").append(escapeJson(m.messageHash)).append("\",\n");
            json.append("    \"recipient\": \"").append(escapeJson(m.recipient)).append("\",\n");
            json.append("    \"messageText\": \"").append(escapeJson(m.messageText)).append("\"\n");
            json.append("  }");

            if (i < storedMessages.size() - 1)
            {
                json.append(",");
            }
            json.append("\n");
        }
        json.append("]");

        try (FileWriter writer = new FileWriter("StoredMessages.json"))
        {
            writer.write(json.toString());
        }
        catch (IOException e)
        {
            System.out.println("Could not write the JSON file: " + e.getMessage());
        }
        return json.toString();
    }

    // checks the message is within the 250 character limit
    public boolean checkMessageLength() {
        return messageText != null && messageText.length() <= 250;
    }

    // makes text safe to place inside JSON quotes
    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}


