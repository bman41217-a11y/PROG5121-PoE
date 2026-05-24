/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bshon
 */
public class Part2_messagesTest {
    
    public Part2_messagesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkMessageID method, of class Part2_messages.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Part2_messages instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientNumber method, of class Part2_messages.
     */
    @Test
    public void testCheckRecipientNumber() {
        System.out.println("checkRecipientNumber");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.checkRecipientNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Part2_messages.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class Part2_messages.
     */
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.sentMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageLength method, of class Part2_messages.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.checkMessageLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class Part2_messages.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        String messageID = "";
        String messageText = "";
        String recipientNumber = "";
        String messageHash = "";
        Part2_messages.storeMessage(messageID, messageText, recipientNumber, messageHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessage method, of class Part2_messages.
     */
    @Test
    public void testPrintMessage() {
        System.out.println("printMessage");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.printMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecipient method, of class Part2_messages.
     */
    @Test
    public void testSetRecipient() {
        System.out.println("setRecipient");
        String recipientNumber = "";
        Part2_messages instance = null;
        instance.setRecipient(recipientNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageText method, of class Part2_messages.
     */
    @Test
    public void testSetMessageText() {
        System.out.println("setMessageText");
        String messageText = "";
        Part2_messages instance = null;
        instance.setMessageText(messageText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageHash method, of class Part2_messages.
     */
    @Test
    public void testSetMessageHash() {
        System.out.println("setMessageHash");
        String messageHash = "";
        Part2_messages instance = null;
        instance.setMessageHash(messageHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class Part2_messages.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Part2_messages instance = null;
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageID method, of class Part2_messages.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.getMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHash method, of class Part2_messages.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipientNumber method, of class Part2_messages.
     */
    @Test
    public void testGetRecipientNumber() {
        System.out.println("getRecipientNumber");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.getRecipientNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageText method, of class Part2_messages.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        Part2_messages instance = null;
        String expResult = "";
        String result = instance.getMessageText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
