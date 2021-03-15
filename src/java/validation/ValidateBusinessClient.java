/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import problemdomain.BusinessClient;

/**
 * To use this class, first call the startValidation, do your validation and then call getErrorMap
 * @author 839645
 */
public final class ValidateBusinessClient {
    private static ArrayList<String> errList;
    
    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation(){
        errList = new ArrayList<>();
    }
    
    //Basic business client validation
    public static ArrayList<String> getErrorMapForAllfields(String username, String password, String firstName, String lastName, String email, String phoneNo){
        startValidation();
        put("busClientUsername",validateBusClientUsername(username));
        put("busClientPassword",validateBusClientPassword(password));
        put("busClientFirstName",validateBusClientfirstName(firstName));
        put("busClientLastName", validateBusClientlastName(lastName));
        put("busClientEmail",validateBusClientEmail(email));
        put("busClientPhoneNo",validateBusClientPhoneNo(phoneNo));
        return getErrorMap();
    }
    private static void put(String name, String value){
        if(value != null)
            errList.add(value);
    }
    
    //This checks that the username is not empty or too long
    public static String validateBusClientUsername(String username){
        if(isEmpty(username))
            return "Username cannot be empty";
        else if(username.trim().length() > 45)
            return "Username cannot be more than 45 characters";
        else 
            return null;
    }
    
    //This checks that the password is not empty or too long
    public static String validateBusClientPassword(String password){
        if(isEmpty(password))
            return "Password cannot be empty";
        else if(password.length() > 100)
            return "Password cannot be more than 100 characters";
        else 
            return null;
    }
    
    //This checks that the first name is not empty or too long
    public static String validateBusClientfirstName(String firstName){
        if(isEmpty(firstName))
            return "First name cannot be empty";
        else if(firstName.length() > 45)
            return "First name cannot be more than 45 characters";
        else 
            return null;
    }
    
    //This checks that the last name is not empty or too long
    public static String validateBusClientlastName(String lastName){
        if(isEmpty(lastName))
            return "Last name cannot be empty";
        else if(lastName.length() > 45)
            return "Last name cannot be more than 45 characters";
        else 
            return null;
    }
    
    //This checks that the email is not empty or too long. It also checks that it is in the correct email format
    public static String validateBusClientEmail(String email){
        if(isEmpty(email))
            return "Email cannot be empty";
        else if(email.trim().length() > 255)
            return  "Email cannot be more than 255 characters";
        else if(!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$", email))
            return "Invalid email provided";
        else
            return null;
    }
    
    //This checks that the phone number is not empty or too long. It also checks that it is in the correct phone number format
    public static String validateBusClientPhoneNo(String phoneNo){
        if(isEmpty(phoneNo))
            return "Phone no cannot be empty";
        else if(phoneNo.trim().length() > 10)
            return "Phone no cannot be more than 10 characters";
        else if(!Pattern.matches("\\d{10}", phoneNo))
            return "Only 10 digits allowed in phone number";
        else 
            return null;
    }
    
    public static ArrayList<String> getErrorMap(){
        if(errList.isEmpty())
            return null;
        else
            return errList;
    }
    private final static boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
}
