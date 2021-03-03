/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import problemdomain.Education;

/**
 *
 * @author 839645
 */
public class ValidateEducation {
    private static ArrayList<String> errList;
    private static Date start = null;
    private static Date end = null;
    
    public static ArrayList<String> getErrorMapForAllfields(String Institution, String Education_lvl, String Subject, String Start_date, String End_date){
        errList = new ArrayList<>();
        put(checkIfEmpty(Institution, Education_lvl, Subject, Start_date));
        put(checkDates(Start_date, End_date));
        return errList;
    }
   
    private static void put(String str){
        if(str != null){
            errList.add(str);
        }
    }
   
    public static String checkIfEmpty(String institution, String education_lvl, String subject, String start_date){
        // Checking empty fields
        if(isEmpty(institution) || isEmpty(education_lvl) || isEmpty(subject) || isEmpty(start_date))
            return "All fields required";
        else
            return null;
    }
    
    public static String checkDates(String start_date, String end_date){
        // Parsing Dates
                 try {
                    start =new SimpleDateFormat("yyyy-MM-dd").parse(start_date);
                    
                    // Since END_DATE is optional
                    if(end_date.trim().length() > 0){
                        end = new SimpleDateFormat("yyyy-MM-dd").parse(end_date);
                        if(start.compareTo(end) >=  0){
                            return "Start date must be before end date";
                        }
                    }
                    return null;
                } catch (ParseException ex) {
                    return "Invalid date format";
                }
                               
    }
    
    public static void prepareResponse(HttpServletRequest request, String institution, String education_lvl, String subject){
        
        Education edu = new Education();
        edu.setInstitution(institution);
        edu.setLevel(education_lvl);
        edu.setEndDate(end);
        edu.setStartDate(start);
        edu.setSubject(subject);
        request.setAttribute("education", edu);
        
        // Do this if ANY ERRORS
        if(!errList.isEmpty()){
            request.setAttribute("currentTab", "add-education-cta");
        }

    }
    private final static boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
    
}
