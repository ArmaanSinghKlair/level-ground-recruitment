/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.HashMap;
import java.util.regex.Pattern;
import problemdomain.Candidate;

/**
 * To use this class, first call the startValidation, do your validation and then call getErrorMap
 * Another alternalte for basic validation is to simply call validateBasicCandidate
 * @author 839645
 */
public final class ValidateCandidate {
    private static HashMap<String,String> errMap;
    private String canUsername;
    private String canPassword;
    private String canfirstName;
    private String canlastName;
    private String canEmail;
    private String canPhoneNo;
    private String workHistory;
    private String primaryEducation;
    private String secondaryEducation;
    private String certificates;
    private String keySkills;
    private String interestedRoles;
    
    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation(){
        errMap = new HashMap<>();
    }
    
    //Basic candidate validation
    public static HashMap<String,String> validateBasicCandidate(String username, String password, String firstName, String lastName, String email, String phoneNo){
        startValidation();
        validateCanUsername(username);
        validateCanPassword(password);
        validateCanfirstName(firstName);
        validateCanlastName(lastName);
        validateCanEmail(email);
        validateCanPhoneNo(phoneNo);
        return getErrorMap();
    }
    public static void validateCanUsername(String username){
        if(isEmpty(username))
            errMap.put("canUsername","Username cannot be empty");
        else if(username.trim().length() > 45)
            errMap.put("canUsername", "Username cannot be more than 45 characters");
    }
    
    public static void validateCanPassword(String password){
        if(isEmpty(password))
            errMap.put("canPassword","Password cannot be empty");
        else if(password.length() > 45)
            errMap.put("canPassword", "Password cannot be more than 45 characters");
    }
    
    public static void validateCanfirstName(String firstName){
        if(isEmpty(firstName))
            errMap.put("canfirstName","First name cannot be empty");
        else if(firstName.length() > 45)
            errMap.put("canfirstName", "First name cannot be more than 45 characters");
    }
    
    public static void validateCanlastName(String lastName){
        if(isEmpty(lastName))
            errMap.put("canlastName","Last name cannot be empty");
        else if(lastName.length() > 45)
            errMap.put("canlastName", "Last name cannot be more than 45 characters");
    }
    
    public static void validateCanEmail(String email){
        if(isEmpty(email))
            errMap.put("canEmail","Email cannot be empty");
        else if(email.trim().length() > 255)
            errMap.put("canEmail", "Email cannot be more than 255 characters");
        else if(!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$", email))
            errMap.put("canEmail","Invalid email provided");
    }
    
    public static void validateCanPhoneNo(String phoneNo){
        if(isEmpty(phoneNo))
            errMap.put("canPhoneNo","Phone no cannot be empty");
        else if(phoneNo.trim().length() > 10)
            errMap.put("canPhoneNo", "Phone no cannot be more than 10 characters");
        else if(!Pattern.matches("\\d{10}", phoneNo))
            errMap.put("canPhoneNo","Only 10 digits allowed in phone number");
    }
    
    public static HashMap<String,String> getErrorMap(){
        if(errMap.isEmpty())
            return null;
        else
            return errMap;
    }
    private final static boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
}
