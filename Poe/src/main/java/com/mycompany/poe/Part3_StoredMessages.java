/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author bshon
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Part3_StoredMessages {
    
    private ArrayList<String> sentMessages = new ArrayList<>();
    private ArrayList<String> disregardedMessages = new ArrayList<>();
    private ArrayList<String> storedMessages = new ArrayList<>();
    private ArrayList<String> messageHashes = new ArrayList<>();
    private ArrayList<String> messageIDs = new ArrayList<>();
    
    private ArrayList<String> senders = new ArrayList<>();
    private ArrayList<String> recipients = new ArrayList<>();
    
    private Scanner input = new Scanner(System.in);
    
    public void populateArrayFromJson(String filePath){
        try{
            if(!Files.exists(Paths.get(filePath))){
                System.out.println("Storage source file was not found.");
                return;
            }
            
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath))).trim();
            
            String[] records = jsonContent.split("\\s*\\}\\s*,\\s*\\{\\s*");
            for(String record : records){
                String id = extractJsonValue(record, "messageID");
                String hash = extractJsonValue(record, "messageHash");
                String content = extractJsonValue(record, "content");
                String sender = extractJsonValue(record,"sender");
                String recipient = extractJsonValue(record, "recipient");
                String type = extractJsonValue(record, "type");
                
                if(!id.isEmpty()){
                    messageIDs.add(id);
                    messageHashes.add(hash);
                    storedMessages.add(content);
                    senders.add(sender);
                    recipients.add(recipient);
                    
                    if("disregarded".equalsIgnoreCase(type)){
                        disregardedMessages.add(content);
                    }else{
                        sentMessages.add(content);
                    }
                }
            }
            System.out.println("The data arrays have been populated successfully.Records parsed: "+messageIDs.size());
        }catch(IOException e){
            System.out.println("Error reading JSON file context: "+e.getMessage());
        }
    }
    
    private String extractJsonValue(String json, String key){
        String pattern = "\"" + key + "\":\"";
        int start = json.indexOf(pattern);
        if(start == -1){
          pattern = "\"" + key + "\":\"";
          start = json.indexOf(pattern);
          if(start == -1)return "";
          int end = json.indexOf(",", start);
          if(end == -1 )end = json.indexOf("}", start);
          return json.substring(start + pattern.length(), end).trim().replace("\"", "");
        }
        int end = json.indexOf("\"", start + pattern.length());
        return json.substring(start + pattern.length(), end);                 
    }
    
    public void displayStoredMessages(){
        boolean exitMenu = false;
        while(!exitMenu){
            System.out.println("\n---------- Stored Messages Menu ----------------");
            System.out.println("a. Display sender and recipient of all stored messages.");
            System.out.println("b. Display the longest stored message.");
            System.out.println("c. Search for message ID and view recipient & message.");
            System.out.println("d. Search for all messages stored for a particilar recipient.");
            System.out.println("e. Delete a message using the unique message hash.");
            System.out.println("f. Display fulldetails report of all stored messages.");
            System.out.println("g. Return to previous Main Menu");
            System.out.print("Select an option (a-g): ");
            
            String selection = input.nextLine().trim().toLowerCase();
            
            switch(selection){
                case "a": displayAllSendersAndRecipients(); break;
                case "b": displayLongestMessage(); break;
                case "c": searchByMessageID(); break;
                case "d": searchByRecipientName(); break;
                case "e": deleteMessageByHash(); break;
                case "f": displayFullDetailsReport(); break;
                case "g":
                    exitMenu = true;
                    System.out.println("Returning to the base interface...");
                    break;
                default:
                    System.out.println("Selection Error: Please enter a a valid option (a-g).");
            }
        }
    }
    
    public void displayAllSendersAndRecipients(){
        if(storedMessages.isEmpty()){
            System.out.println("There are no records found inside the stored data blocks");
            return;
        }
        System.out.println("\n------- Stored Messages: Senders & Recipients -------");
        for(int i = 0; i < storedMessages.size(); i++){
            System.out.printf("Message [%d] -> Sender: %s | Recipient: %s\n", (i + 1), senders.get(i), recipients.get(i));
        }
    }
    
    public void displayLongestMessage(){
        if(storedMessages.isEmpty()){
          System.out.println("There are np records available to calculate.");
          return;
        }
        
        int longestIndex = 0;
        for(int i = 1; i < storedMessages.size(); i++){
            if(storedMessages.get(i).length() > storedMessages.get(longestIndex).length()){
                longestIndex = i;
            } 
        }
        
        System.out.println("\n---- Longest Stored Message Record -----");
        System.out.println("Message ID: "+messageIDs.get(longestIndex));
        System.out.println("Character Length: "+storedMessages.get(longestIndex));
        System.out.println("Text Content: "+storedMessages.get(longestIndex));
    }
    
    public void searchByMessageID(){
        System.out.print("Enter thr target Message ID lookup key: ");
        String searchTarg = input.nextLine().trim();
        
        int foundIndex = messageIDs.indexOf(searchTarg);
        if(foundIndex != -1){
            System.out.println("\nMatch Found:");
            System.out.println("Target recipient: "+recipients.get(foundIndex));
            System.out.println("Message Content: "+storedMessages.get(foundIndex));
        }else{
            System.out.println("Search Failed: Message ID does not exist.");
        }
    }
    
    public void searchByRecipientName(){
        System.out.print("Enter target recipient name: ");
        String searchTarg = input.nextLine();
        
        boolean foundMatch = false;
        System.out.println("\n-- Matching Recipients Found --");
        for(int i = 0; i < recipients.size(); i++){
            if(recipients.get(i).equalsIgnoreCase(searchTarg)){
                System.out.printf("Message ID: %s | Content: %s\n", messageIDs.get(i), storedMessages.get(i));
                foundMatch = true;
            }
        }
        if(!foundMatch){
            System.out.println("No message records were found.");
        }
    }
    
    public void deleteMessageByHash(){
        System.out.print("Enter the Message Hash code for removal: ");
        String targHash = input.nextLine().trim();
        
        int matchIndex = messageHashes.indexOf(targHash);
        if(matchIndex != -1){
            String droppedID = messageIDs.remove(matchIndex);
            String droppedMsg = storedMessages.remove(matchIndex);
            messageHashes.remove(matchIndex);
            senders.remove(matchIndex);
            recipients.remove(matchIndex);
            
            sentMessages.remove(droppedID);
            disregardedMessages.remove(droppedMsg);
            
            System.out.println("Successful: The record tracking for the ID is "+droppedID+" 'dropped.");
        }else{
            System.out.println("Action Failed.");
        }
    }
    
    public void displayFullDetailsReport(){
        if(messageIDs.isEmpty()){
          System.out.println("The records are empty.");
          return;
        }
        System.out.println("\n===== Stored Data Full Report =====");
        System.out.println("Total Messages Found: "+messageIDs.size());
        System.out.println("===========================================");
        
        for(int i = 0; i < messageIDs.size(); i++){
            System.out.println(" RECORD #" + (i + 1));
            System.out.println(" - Message ID : "+messageIDs.get(i));
            System.out.println(" - Hash Code  : "+messageHashes.get(i));
            System.out.println(" - Sender     : "+senders.get(i));
            System.out.println(" - Recipient  : "+recipients.get(i));
            System.out.println(" - Text Message: "+storedMessages.get(i));
        }
        
        System.out.println("========== END OF REPORT ==============");
    }
}
