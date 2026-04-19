/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part1;

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
public class Part1Test {
    
    public Part1Test() {
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
     * Test of main method, of class Part1.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Part1.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testsValidPhoneNumber(){
        //Test a number a starting with a plus sign
        assertEquals(true,Part1.isValidCellPhoneNumber("+27667279345"));
        //Test a invalid number starting without a plus sign
        assertEquals(false,Part1.isValidCellPhoneNumber("svgd2354647"));
    }
    
    @Test 
    public void testUsernameValidation_ReturnsErrorOrSuccessMessage(){
        assertEquals(true,Login.checkUsername("Ky_l"),"Username is valid.");
        assertEquals(false,Login.checkUsername("Peter"),"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        assertEquals(false,Login.checkUsername("Peter Parker"),"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
    }
    
    @Test
    public void testPassworCompexity_ReturnsErrorOrSuccessMessage(){
        assertEquals(true, Login.checkPasswordComplexity("Buz@1234"), "Password successfully captured!");
        assertEquals(false, Login.checkPasswordComplexity("ghbr"),"Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
    }   
}
