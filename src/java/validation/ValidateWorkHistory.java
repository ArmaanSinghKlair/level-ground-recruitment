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
import problemdomain.WorkHistory;

/**
 *
 * @author 839645
 */
public final class ValidateWorkHistory {
    private static ArrayList<String> errList;
    private static Date start = null;
    private static Date end = null;
    
    public static ArrayList<String> getErrorMapForAllfields(String company, String title, String start_date, String end_date, String reference){
        errList = new ArrayList<>();
        put(checkEmpty(company, title, start_date));
        put(checkDates(start_date, end_date));
        return errList;
    }
    
    public static String checkEmpty(String company, String title, String start_date){
        // Checking empty fields
        if(isEmpty(company.trim()) || isEmpty(title.trim()) || isEmpty(start_date.trim()))
            return "All fields required";
        else
            return null;
    }
    private static void put(String str){
        if(str != null){
            errList.add(str);
        }
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
    
    public static void prepareResponse(HttpServletRequest request, String company, String title, String reference){
        // Prepare education object here itself, if error then used in jsp if NO ERROR, used in data access class
                    WorkHistory wh = new WorkHistory();
                    wh.setCompany(company);
                    wh.setTitle(title);
                    wh.setStartDate(start);
                    wh.setEndDate(end);
                    wh.setReference(reference);
                    

                
                // Do this if ANY ERRORS
                if(!errList.isEmpty()){
                    request.setAttribute("currentTab", "add-workHistory-cta");
                    request.setAttribute("workHistory", wh);
                }
                
    }
      private final static boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
    

}
