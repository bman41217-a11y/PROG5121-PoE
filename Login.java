/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

/**
 *
 * @author bshon
 */
import java.util.Scanner;

public class Login {

    
    //method to check username validity
    public static boolean checkUsername(String username){
        return username.contains("_") && username.length() <= 5;
    } 
    //method to check password complexity
    public static boolean checkPasswordComplexity(String password){
        if(password.length() < 8){
            return false;
        }
        
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;
        
        for(int b = 0; b < password.length(); b++){
            char c = password.charAt(b);
            if(Character.isUpperCase(c)){
                hasUpperCase = true;
            }else if(Character.isDigit(c)){
                hasDigit = true;
            }else if(!Character.isLetterOrDigit(c)){
                hasSpecialCharacter = true;
            }
        }
        return hasUpperCase && hasDigit && hasSpecialCharacter;
    }
    
    //method to check phone number validity
    public static boolean checkPhoneNumber(String phoneNumber){
        return phoneNumber.startsWith("+") && phoneNumber.length() >= 10;
    }
    
    //method to register user
    public static String registerUser(String username, String password){
        if(checkUsername(username)){
            return "Username is incorrectly formatted.";
        }
        if(checkPasswordComplexity(password)){
           return "Registration failed. Password is not complex enough."; 
        }        
        return "The two above conditions have been met and the user has been registered successfully.";
    }
    
    //method to login user
    public static boolean loginUser(String username, String password, String registeredUsername, String registeredPassword ){
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }
     
    //method to return login status
    public static String returnLoginStatus(String username, String password, String registeredUsername, String registeredPassword){
        if(loginUser(username, password, registeredUsername, registeredPassword)){
            return "Login successful!";
        }else{
            return "A failed login attempt.";
        }
    }
        
              
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        //variables to store registered username and password, and registration status
        String registeredUsername = "";
        String registeredPassword = "";
        boolean registrationSuccess = false;
        
        //prompt user for registration details
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        //call registerUser method and store the message
        String message = registerUser(username, password);
        System.out.println(""+message);
        
        if(message.contains("successful")){
            registeredUsername = username;
            registeredPassword = password;
            registrationSuccess = true;
            
            System.out.println("Registration successful! You can now log in.");
        }else{
            System.out.println("Registration failed. Please check your input and try again.");
        }

        
        
        //prompt user for login details
        System.out.print("Enter username to login: ");
        String loginUsername = input.nextLine();
        
        System.out.print("Enter password to login: ");
        String loginPassword = input.nextLine();
        
        System.out.print("Enter your cell phone number: ");
        String phoneNumber = input.nextLine();
        
   

        //validate the login credentials and print the appropriate message
        if(loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword)){
            System.out.println("Login successful. Welcome, " + loginUsername + "!");
        } 
        else{
           System.out.println("Login failed. Invalid username or password."); 
        }
         
        
    }
       
}

