
package com.mycompany.prog.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessagesTest {

    private Messages message;

    @BeforeEach
    public void setUp() {
        Messages.clearAllMessages();
        message = new Messages(
                1,
                "+27831234567",
                "Hi thanks"
        );
    }

    @Test
    public void testCheckMessageID() {
        assertTrue(message.checkMessageID(),
                "Message ID should be valid");
    }

    @Test
    public void testCheckRecipientCellValid() {
        assertEquals(
                "Cell number successfully captured.",
                message.checkRecipientCell()
        );
    }

    @Test
    public void testCheckRecipientCellInvalid() {
        Messages invalidMessage =
                new Messages(2, "12345", "Hello");

        assertTrue(
                invalidMessage.checkRecipientCell()
                        .contains("incorrectly formatted")
        );
    }

    @Test
    public void testCheckMessageLengthValid() {
        assertTrue(message.checkMessageLength(),
                "Message with 250 characters or fewer should be valid");
    }

    @Test
    public void testCheckMessageLengthInvalid() {
        String longText = "A".repeat(251);

        Messages longMessage =
                new Messages(3, "+27831234567", longText);

        assertFalse(longMessage.checkMessageLength(),
                "Message exceeding 250 characters should be invalid");
    }

    @Test
    public void testCreateMessageHash() {
        String hash = message.createMessageHash();

        assertNotNull(hash);
        assertFalse(hash.isEmpty());
        assertEquals(hash, hash.toUpperCase());
    }

    @Test
    public void testSentMessage() {
        assertEquals(
                "Message successfully sent",
                message.SentMessage("1")
        );

        assertEquals(1, Messages.returnTotalMessages());
    }

    @Test
    public void testStoreMessageChoice() {
        assertEquals(
                "Message successfully stored",
                message.SentMessage("3")
        );
    }

    @Test
    public void testInvalidMessageChoice() {
        assertEquals(
                "Invalid choice.",
                message.SentMessage("5")
        );
    }

    @Test
    public void testPrintMessagesWhenEmpty() {
        assertEquals(
                "No messages have been sent yet.",
                message.printMessages()
        );
    }

    @Test
    public void testPrintMessage() {
        String printedMessage = message.printMessage();

        assertTrue(printedMessage.contains("Message ID:"));
        assertTrue(printedMessage.contains("Message Hash:"));
        assertTrue(printedMessage.contains("+27831234567"));
        assertTrue(printedMessage.contains("Hi thanks"));
    }

    @Test
    public void testReturnTotalMessages() {
        assertEquals(0, Messages.returnTotalMessages());

        message.SentMessage("1");

        assertEquals(1, Messages.returnTotalMessages());
    }

    @Test
    public void testClearAllMessages() {
        message.SentMessage("1");

        assertEquals(1, Messages.returnTotalMessages());

        Messages.clearAllMessages();

        assertEquals(0, Messages.returnTotalMessages());
    }
}
