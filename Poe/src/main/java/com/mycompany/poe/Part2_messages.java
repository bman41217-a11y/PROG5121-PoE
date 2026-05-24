/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author bshon
 */
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import java.io.FileWriter;
import java.util.List;

public class Part2_messages {
    
    private String messageID;
    private int messageNumber;
    private String recipientNumber;
    private String messageText;
    private String messageHash;
    //Constructer
    public Part2_messages(int messageNumber, String recipientNumber, String messageText){
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipientNumber = recipientNumber;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
        
    } 
    //method to generate random message ID
    private String generateMessageID(){
        Random rand = new Random();
        long id = 20000000000L + (long) rand.nextDouble()* 20000000000L;
        return String.valueOf(id);
    }
    //method to check if message ID is 10 characters or less
    public boolean checkMessageID(){
        return messageID.length() <= 10;
    }
    //method to check if recipient number is valid, if not an error message will be returned
    public String checkRecipientNumber(){
        if(recipientNumber.length() <= 12 && recipientNumber.startsWith("+27")){
            return "Phone number has been successfully captured.";
        }else{
            return "Cell phone number is incorrectly formatted or does not contain a international code.";
        }
    }
    //method to create message hash 
    public String createMessageHash(){
        String[] words = messageText.trim().split("");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String firstTwo = messageID.substring(0,2);
        return (firstTwo + " : " + messageNumber + " : "+ firstWord + lastWord).toUpperCase();
    }
    //Method to interact with the user 
    public String sentMessage(){
        Scanner input = new Scanner(System.in);
        
        System.out.println(" ");
        System.out.println("Choose an option below: ");
        System.out.println("1. Send Message.");
        System.out.println("2. Disregard Message.");
        System.out.println("3. Store message to send later.");
        System.out.print("Choose between 1,2, or 3: ");
        
        String choice = input.nextLine();
        switch(choice){
            case "1":
                return "Message successfully sent.";
            case "2":
                System.out.print("Press (0) to delete your message: ");
                String deleteChoice = input.nextLine();
                if(deleteChoice.matches("0")){
                    return "Message has been deleted.";
                }
                return "Message discarded.";
            case "3":
                storeMessage(messageID, recipientNumber,messageHash, messageText);
                return "Message succefully stored";
            default:
                return "Invalid Option.";
        }
        
        
    }
    //method to check if message is 250 characters or less
    public String checkMessageLength(){
        if(messageText.length() > 250 ){
            int excess = messageText.length() - 250;
            return "Please enter a message of less than 250 characters, your word count is "+excess+".";
        }
       return "Message sent.";     
    }
    //method to store message in a JSON file
    public static void storeMessage(String messageID, String messageText, String recipientNumber, String messageHash){
        String json ="{\n" +
                "  \"messageID\": \"" + messageID + "\", \n" +
                "  \"message\": \"" + messageText + "\",\n" +
                "  \"recipientNumber\": \"" + recipientNumber + "\",\n" +
                "  \"messageHash\": \"" + messageHash + "\",\n" +
                "}";
        
        try{
            java.io.FileWriter write = new java.io.FileWriter("message.json", true);
            write.write(json + "\n");
            write.close();
        }catch(IOException e){
            System.out.println("Error message could not be stored");
        }
                  
    }
    //method to print message details
    public String printMessage(){
        return "\nMessageID: " +messageID
                +"\nMessage Hash: "+messageHash
                +"\nRecipient Number: "+recipientNumber
                +"\nMessage Text: "+messageText;
    }
    
  
    //getters and setters
    public void setRecipient(String recipientNumber){
        this.recipientNumber = recipientNumber;
    }
    
    public void setMessageText(String messageText){
        this.messageText = messageText;
    }
    
    public void setMessageHash(String messageHash){
        this.messageHash = messageHash;
    }
    
    public int returnTotalMessages(){
        return messageNumber;
    }
    
    public String getMessageID(){
        return messageID;
    }
    
    public String getMessageHash(){
        return messageHash;
    }
    
    public String getRecipientNumber(){
        return recipientNumber;
    }
    
    public String getMessageText(){
        return messageText;
    }
    
        
    
    
}
