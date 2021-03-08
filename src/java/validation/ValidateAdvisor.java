/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author 756887
 */
public class ValidateAdvisor {
    
private static ArrayList<String> errList;
    
    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation(){
        errList = new ArrayList<>();
    }
    

    // basic advisor validation
    public static ArrayList<String> getErrorMapForSignup(String username, String password, String firstName, String lastName, String email){
        startValidation();
        put("advisorUsername",validateAdvisorUsername(username));
        put("advisorPassword",validateAdvisorPassword(password));
        put("advisorfirstName",validateAdvisorfirstName(firstName));
        put("advisorlastName", validateAdvisorlastName(lastName));
        put("advisorEmail",validateAdvisorEmail(email));
        return getErrorMap();
    }
    
    private static void put(String name, String value){
        if(value != null)
            errList.add(value);
    }
    public static String validateAdvisorUsername(String username){
        if(isEmpty(username))
            return "Username cannot be empty";
        else if(username.trim().length() > 45)
            return "Username cannot be more than 45 characters";
        else 
            return null;
    }
    
    public static String validateAdvisorPassword(String password){
        if(isEmpty(password))
            return "Password cannot be empty";
        else if(password.length() > 100)
            return "Password cannot be more than 100 characters";
        else 
            return null;
    }
    
    public static String validateAdvisorfirstName(String firstName){
        if(isEmpty(firstName))
            return "First name cannot be empty";
        else if(firstName.length() > 45)
            return "First name cannot be more than 45 characters";
        else 
            return null;
    }
    
    public static String validateAdvisorlastName(String lastName){
        if(isEmpty(lastName))
            return "Last name cannot be empty";
        else if(lastName.length() > 45)
            return "Last name cannot be more than 45 characters";
        else 
            return null;
    }
    
    public static String validateAdvisorEmail(String email){
        if(isEmpty(email))
            return "Email cannot be empty";
        else if(email.trim().length() > 255)
            return  "Email cannot be more than 255 characters";
        else if(!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$", email))
            return "Invalid email provided";
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
