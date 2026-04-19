/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part1;

/**
 *
 * @author bshon
 */
import java.util.Scanner;

public class Part1 {
    
    //Metho to validate phone number format
    public static boolean isValidCellPhoneNumber(String phoneNumber){
        //Expressions to match valid formats
         String regex = "^\\+\\d{1,11}";
         return phoneNumber.matches(regex);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
                
        String username;
        String password;
        
        //Username and password validation
        do{
            System.out.print("Enter username: ");
            username = input.nextLine();
            
            System.out.print("Enter password: ");
            password = input.nextLine();
            
            if(username.contains("_")&& username.length() <= 5){
                System.out.println("Username successfully captured.");
            }
            else{
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            }
            if(password.length() <=8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*")){
                System.out.println("Password successfully captured.");
            }
            else{
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            }
        }while(!(username.contains("_")&& username.length() <=5) || !(password.length() <=8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*")));
        
        //phone number validation
        System.out.print("Enter your cell phone number: ");
        String phoneNumber = input.nextLine();
        if(isValidCellPhoneNumber(phoneNumber)){
            System.out.println("Cell phone number successfully added");
        }
        else{
            System.out.println("Cell phone number is incorrectly formatted or does not contain a international code.");
        }
    }
}
