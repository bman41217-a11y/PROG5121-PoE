/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;

/**
 *
 * @author bshon
 */
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        login userLogin = new login();        
        
        //Part 1 of Poe
        
        String username;
        String password;
        String phoneNumber;
        
        do{
          System.out.println("---- Registration ----");
          System.out.print("Enter username: ");
          username = input.nextLine();
          
          if(!userLogin.checkUsername(username)){
             System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length"); 
          }
        }while(!userLogin.checkUsername(username));
        System.out.println("Username Succefully Captured.");
        
        do{
            System.out.print("Enter password: ");
            password = input.nextLine();
            
            if(!userLogin.checkPasswordComplexity(password)){
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            }
        }while(!userLogin.checkPasswordComplexity(password));
        System.out.println("Passwoerd succefully Captured.");
        
        do{
            System.out.print("Enter your cell phone number: ");
            phoneNumber = input.nextLine();
            
            if(userLogin.checkPhoneNumber(phoneNumber)){
                System.out.println("Cell phone number is incorrectly formatted or does not contain a international code.");
            }
        }while(!userLogin.checkPhoneNumber(phoneNumber));
        System.out.println("Cell phone number successfully added");
        
        String registrationMessage = userLogin.registerUser(username, password);
        System.out.println(registrationMessage);
        
        System.out.println("\n------ LOGIN DETAILS -------");
        
        System.out.print("Enter username to Login: ");
        String loginUsername = input.nextLine();
        
        System.out.print("Enter password to Login: ");
        String loginPassword = input.nextLine();
        
        boolean loginResult = userLogin.loginUser(loginUsername, loginPassword);
        
        System.out.println(userLogin.returnLoginStatus(loginResult));
      
        
        //Part 2 of Poe
        
        //Loop to check if user has succefully logged in to use the QuickChat
        if(userLogin.loginUser(loginUsername, loginPassword)){
            System.out.println("---- Welcome to QuickChat ----");
            boolean run = true;
            int totalMessagesSent = 0;
            
            while(run){
                System.out.println("Menu: ");
                System.out.println("1.Send Message.");
                System.out.println("2. Show recent messages");
                System.out.println("3. Quit.");
                System.out.print("Choose an option(1,2, or 3): ");
                String choice = input.nextLine();
                //switch statement to navigate menu options
                switch(choice){
                    case"1":
                        System.out.print("Amount of messages you want to send?: ");
                        int numMessages = Integer.parseInt(input.nextLine());
                        
                        
                        //loop to send multiple messages
                        for(int b = 0; b < numMessages; b++ ){
                            int messageNumber = (b + 1);
                            
                            System.out.println("Message "+messageNumber);
                            System.out.print("Enter recipients phone number (must start with +27): ");
                            String recipientNumber = input.nextLine();
                            //creating message object and checking if recipient number is valid, if not user will be prompted to enter recipient number again until it is valid
                            Part2_messages messagesObj = new Part2_messages(messageNumber, recipientNumber,"");
                            while(!messagesObj.checkRecipientNumber().matches("Phone number has been successfully captured.")){
                                System.out.println(messagesObj.checkRecipientNumber());
                                System.out.print("Enter recipients phone number again (must start with +27): ");
                                recipientNumber = input.nextLine();
                               
                                messagesObj.setRecipient(recipientNumber);
                            }
                            
                            System.out.print("Enter a message you would like to send: ");
                            String messageText = input.nextLine();
                            //loop to check if message is 250 characters or less
                            while(messageText.length() > 250){
                                System.out.println("Please enter a message of 250 characters or less.");
                                System.out.print("Please enter your message again: ");
                                messageText = input.nextLine();
                            }
                            
                            System.out.println("");
                            //setting message text, creating message hash and sending message
                            messagesObj.setMessageText(messageText);
                            messagesObj.setMessageHash(messagesObj.createMessageHash());
                            System.out.println("Message has been sent.");
                            
                            String outcome = messagesObj.sentMessage();
                            System.out.println(outcome);
                             //if message is successfully sent, total messages sent will increase by 1 and message details will be printed
                            if(outcome.matches("Message successfully sent.")){
                               totalMessagesSent++;
                               System.out.println(messagesObj.printMessage());
                            }
                    }
                        System.out.println("Total amount of messages sent: "+totalMessagesSent);
                        break;
                        
                    case "2":
                        System.out.println("Coming Soon.");
                        break;
                        
                    case "3":
                        run = false;
                        System.out.println("Application Closed.");
                        break;
                        
                    default:
                        System.out.println("Please enter a valid number (1,2, or 3).");
                }

                        
            }
        }      
        
    }        
}    
    
