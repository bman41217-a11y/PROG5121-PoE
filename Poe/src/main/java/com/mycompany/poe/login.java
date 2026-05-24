/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author bshon
 */
public class login {
    
    private String storedUsername;
    private String storedPassword;

    
    //method to check username validity
    public  boolean checkUsername(String username){
        return username.contains("_") && username.length() <= 5;
    } 
    //method to check password complexity
    public  boolean checkPasswordComplexity(String password){
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
    public  boolean checkPhoneNumber(String phoneNumber){
        return phoneNumber.startsWith("+") && phoneNumber.length() >= 10;
    }
    
    //method to register user
    public  String registerUser(String username, String password){
        if(!checkUsername(username)){
            return "Username is incorrectly formatted.";
        }
        if(!checkPasswordComplexity(password)){
           return "Registration failed. Password is not complex enough."; 
        } 
        //Storing username and password to validate login details 
        storedUsername = username;
        storedPassword = password;
        
        return "The two above conditions have been met and the user has been registered successfully.";
    }
    
    //method to login user
    public  boolean loginUser(String username, String password ){
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
     
    //method to return login status
    public  String returnLoginStatus(boolean loginSuccess){
        if(loginSuccess){
            return "Login successful! Welcome back "+storedUsername+" !";
        }else{
            return "A failed login attempt.";
        }
    }
        
              
    
    public static void main(String[] args){
        
    }
      
}


