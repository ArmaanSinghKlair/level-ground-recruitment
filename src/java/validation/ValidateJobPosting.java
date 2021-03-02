/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 *
 * @author 756887
 */
public class ValidateJobPosting {
    private static ArrayList<String> errList;
    
    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation(){
        errList = new ArrayList<>();
    }
    
    //Basic business client validation
    public static ArrayList<String> getErrorMapForAllfields(String title, String requirements, Date startDate, Date endDate, String status, String description){
        startValidation();
        put("jobTitle",validateJobTitle(title));
        put("jobRequirements",validateJobRequirements(requirements));
        put("jobStartDate",validateJobStartDate(startDate, endDate));
        put("jobEndDate", validateJobEndDate(startDate, endDate));
        put("jobStatus",validateJobStatus(status));
        put("jobDescription",validateJobDescription(description));
        return getErrorMap();
    }
    private static void put(String name, String value){
        if(value != null)
            errList.add(value);
    }
    public static String validateJobTitle(String title){
        if(isEmpty(title))
            return "Title cannot be empty";
        else if(title.trim().length() > 45)
            return "Title cannot be more than 45 characters";
        else 
            return null;
    }
    
    public static String validateJobRequirements(String requirements){
        if(isEmpty(requirements))
            return "Requirements cannot be empty";
        else if(requirements.length() > 100)
            return "Requirements cannot be more than 100 characters";
        else 
            return null;
    }
    
    public static String validateJobStartDate(Date startDate, Date endDate){
        if(startDate.after(endDate))
            return "Start date cannot be after end date";
        else if(startDate.before(new Date()))
            return "Start date cannot be before today";
        else 
            return null;
    }
    
    public static String validateJobEndDate(Date startDate, Date endDate){
        if(endDate.after(startDate))
            return "End date cannot be before start date";
        else if(endDate.before(new Date()))
            return "end date cannot be before today";
        else 
            return null;
    }
    
    public static String validateJobStatus(String status){
        if(isEmpty(status))
            return "Status cannot be empty";
        else if(status.trim().length() > 45)
            return "Status cannot be more than 45 characters";
        else 
            return null;
    }
    
    public static String validateJobDescription(String description){
        if(isEmpty(description))
            return "Description cannot be empty";
        else if(description.length() > 100)
            return "Description cannot be more than 100 characters";
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
