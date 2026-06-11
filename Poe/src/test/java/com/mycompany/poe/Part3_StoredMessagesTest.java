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
public class Part3_StoredMessagesTest {
    
    public Part3_StoredMessagesTest() {
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
     * Test of populateArrayFromJson method, of class Part3_StoredMessages.
     */
    @Test
    public void testPopulateArrayFromJson() {
        System.out.println("populateArrayFromJson");
        String filePath = "";
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.populateArrayFromJson(filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayStoredMessages method, of class Part3_StoredMessages.
     */
    @Test
    public void testDisplayStoredMessages() {
        System.out.println("displayStoredMessages");
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.displayStoredMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllSendersAndRecipients method, of class Part3_StoredMessages.
     */
    @Test
    public void testDisplayAllSendersAndRecipients() {
        System.out.println("displayAllSendersAndRecipients");
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.displayAllSendersAndRecipients();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestMessage method, of class Part3_StoredMessages.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.displayLongestMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByMessageID method, of class Part3_StoredMessages.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.searchByMessageID();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByRecipientName method, of class Part3_StoredMessages.
     */
    @Test
    public void testSearchByRecipientName() {
        System.out.println("searchByRecipientName");
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.searchByRecipientName();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMessageByHash method, of class Part3_StoredMessages.
     */
    @Test
    public void testDeleteMessageByHash() {
        System.out.println("deleteMessageByHash");
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.deleteMessageByHash();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFullDetailsReport method, of class Part3_StoredMessages.
     */
    @Test
    public void testDisplayFullDetailsReport() {
        System.out.println("displayFullDetailsReport");
        Part3_StoredMessages instance = new Part3_StoredMessages();
        instance.displayFullDetailsReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
