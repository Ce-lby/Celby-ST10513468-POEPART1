/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Celby
 */


package com.mycompany.prog.part1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Messages {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    private static ArrayList<Messages> sentMessages =
            new ArrayList<>();

    private static ArrayList<Messages> storedMessages =
            new ArrayList<>();

    // Default constructor
    public Messages() {
        this(1, "+27831234567", "HI THANKS");
    }

    // Constructor used by JUnit tests
    public Messages(int messageNumber, String recipient,
                    String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateRandomID();
        this.messageHash = createMessageHash();
    }

    private String generateRandomID() {
        Random rand = new Random();
        long id = 1000000000L
                + (long) (rand.nextDouble() * 9000000000L);

        return String.valueOf(id);
    }

    public boolean checkMessageID() {
        return messageID != null
                && messageID.matches("\\d{1,10}");
    }

    public String checkRecipientCell() {
        String error = "Cell number is incorrectly formatted or does not "
                + "contain an international code; please correct the "
                + "number and try again.";

        if (recipient == null
                || !recipient.startsWith("+27")
                || recipient.length() != 12) {
            return error;
        }

        for (int i = 3; i < recipient.length(); i++) {
            if (!Character.isDigit(recipient.charAt(i))) {
                return error;
            }
        }

        return "Cell number successfully captured.";
    }

    public boolean checkMessageLength() {
        return messageText != null
                && messageText.length() <= 250;
    }

    public String createMessageHash() {
        String firstTwoID =
                messageID != null && messageID.length() >= 2
                ? messageID.substring(0, 2) : "00";

        String firstWord = "";
        String lastWord = "";

        if (messageText != null
                && !messageText.trim().isEmpty()) {

            String[] words = messageText.trim().split("\\s+");
            firstWord = words[0];
            lastWord = words[words.length - 1];
        }

        return (firstTwoID + ":" + messageNumber + ":"
                + firstWord + lastWord).toUpperCase();
    }

    public String SentMessage(String actionChoice) {
        if ("1".equals(actionChoice)) {
            sentMessages.add(this);
            return "Message successfully sent";

        } else if ("2".equals(actionChoice)) {
            return "Press 0 to delete the message";

        } else if ("3".equals(actionChoice)) {
            storedMessages.add(this);
            storeMessage();
            return "Message successfully stored";

        } else {
            return "Invalid choice.";
        }
    }

    public String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages have been sent yet.";
        }

        StringBuilder all = new StringBuilder();

        for (Messages msg : sentMessages) {
            all.append(msg.printMessage()).append("\n");
        }

        return all.toString();
    }

    public String printMessage() {
        return "--------------------------------\n"
                + "Message ID: " + messageID + "\n"
                + "Message Hash: " + messageHash + "\n"
                + "Recipient: " + recipient + "\n"
                + "Message: " + messageText + "\n"
                + "--------------------------------";
    }

    public static int returnTotalMessages() {
        return sentMessages.size();
    }

    public String storeMessage() {
        StringBuilder json = new StringBuilder("[\n");

        for (int i = 0; i < storedMessages.size(); i++) {
            Messages m = storedMessages.get(i);

            json.append("  {\n")
                .append("    \"messageID\": \"")
                .append(escapeJson(m.messageID)).append("\",\n")
                .append("    \"messageHash\": \"")
                .append(escapeJson(m.messageHash)).append("\",\n")
                .append("    \"recipient\": \"")
                .append(escapeJson(m.recipient)).append("\",\n")
                .append("    \"messageText\": \"")
                .append(escapeJson(m.messageText)).append("\"\n")
                .append("  }");

            if (i < storedMessages.size() - 1) {
                json.append(",");
            }

            json.append("\n");
        }

        json.append("]");

        try (FileWriter writer =
                     new FileWriter("StoredMessages.json")) {
            writer.write(json.toString());

        } catch (IOException e) {
            System.out.println(
                    "Could not write the JSON file: "
                    + e.getMessage());
        }

        return json.toString();
    }

    private static String escapeJson(String text) {
        if (text == null) {
            return "";
        }

        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    public static void clearAllMessages() {
        sentMessages.clear();
        storedMessages.clear();
    }
}
