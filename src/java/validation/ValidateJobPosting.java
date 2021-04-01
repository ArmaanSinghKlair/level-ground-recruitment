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
    
    //Basic job posting validation
    public static ArrayList<String> getErrorMapForAllfields(String title, String requirements, Date startDate, Date endDate, String status, String description, Double wage, String location){
        startValidation();
        put("jobTitle",validateJobTitle(title));
        put("jobRequirements",validateJobRequirements(requirements));
        put("jobStartDate",validateJobStartDate(startDate, endDate));
        put("jobEndDate", validateJobEndDate(startDate, endDate));
        put("jobStatus",validateJobStatus(status));
        put("jobDescription",validateJobDescription(description));
        put("jobWage",validateJobWage(wage));
        put("jobLocation",validateJobLocation(location));
        return getErrorMap();
    }
    private static void put(String name, String value){
        if(value != null)
            errList.add(value);
    }
    
    //This checks if the job title is not empty or too long
    public static String validateJobTitle(String title){
        if(isEmpty(title))
            return "Title cannot be empty";
        else if(title.trim().length() > 45)
            return "Title cannot be more than 45 characters";
        else 
            return null;
    }
    
    //This checks that the job requirements are not empty or too long
    public static String validateJobRequirements(String requirements){
        if(isEmpty(requirements))
            return "Requirements cannot be empty";
        else if(requirements.length() > 400)
            return "Requirements cannot be more than 400 characters";
        else 
            return null;
    }
    
    //This checks that the start date is before the end date and that the start date is not before today
    public static String validateJobStartDate(Date startDate, Date endDate){
        if(startDate.after(endDate))
            return "Start date cannot be after end date";
        else if(startDate.before(new Date()))
            return "Start date cannot be before current date";
        else
            return null;
    }
    
    //This checks that the end date is after the start date and that the end date is not before today
    public static String validateJobEndDate(Date startDate, Date endDate){
        if(endDate.before(startDate))
            return "End date cannot be before start date";
        else if(endDate.before(new Date()))
            return "End date cannot be before current date";
        else
            return null;
    }
    
    //This checks that the job status is not empty or too long
    public static String validateJobStatus(String status){
        if(isEmpty(status))
            return "Status cannot be empty";
        else if(status.trim().length() > 45)
            return "Status cannot be more than 45 characters";
        else 
            return null;
    }
    
    //This checks that the job description is not empty or too long
    public static String validateJobDescription(String description){
        if(isEmpty(description))
            return "Description cannot be empty";
        else if(description.length() > 400)
            return "Description cannot be more than 400 characters";
        else 
            return null;
    }
    
    //This checks that the wage is not empty and that the wage is not negative
    public static String validateJobWage(Double wage){
        if(wage == 0)
            return "Wage cannot be empty";
        else if(wage < 0)
            return "Wage cannot be negative";
        else 
            return null;
    }
    
    //This checks that the job location is not empty or too long
    public static String validateJobLocation(String location){
        if(isEmpty(location))
            return "Location cannot be empty";
        else if(location.length() > 45)
            return "Location cannot be more than 45 characters";
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
