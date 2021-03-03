/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.AccountServicesDB;
import dataaccess.ProfileServicesDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import problemdomain.Candidate;
import problemdomain.CandidateSkill;
import problemdomain.Education;
import problemdomain.Skill;
import problemdomain.WorkHistory;
import validation.ValidateEducation;
import validation.ValidateSkill;
import validation.ValidateWorkHistory;


/**
 *
 * @author 839645
 */
public final class ProfileServices {
    private final ProfileServicesDB psdb= new ProfileServicesDB();
    private final AccountServicesDB asdb = new AccountServicesDB();

    public final ArrayList<String> profilePageAction(HttpServletRequest request, String username){
        ArrayList<String> errList = new ArrayList<>();
        // Basic parameters needed to identify request
        String submit = request.getParameter("submit");
        String form_name = request.getParameter("form_name");
        String id = request.getParameter("id");
        
        if(isEmpty(submit) || (isEmpty(id) && submit.equals("delete")) || isEmpty(username)){
            errList.add("An error occured. Please reload and try again");
        }
        
        if(errList.size() > 0)
            return errList;
        
        switch(submit){
            case "delete":
              errList = psdb.delete(form_name, id, username);  
            break;
            case "add":
              //Firstly Validate all CREATE requests
              errList = this.validateNewFeature(request, username);
              
              // If no errors
              if(errList.isEmpty()){
                errList = psdb.add(request, username);
              }
            break;
        }
        return errList;
        
        
        
    }
     
    /**
     * VALIDATE requests for create action on profile features
     * @param request
     * @param username
     * @return 
     */
    private final ArrayList<String> validateNewFeature(HttpServletRequest request, String username){
        String form_name = request.getParameter("form_name");
        ArrayList<String> errList = new ArrayList<String>();
        
        switch(form_name){
            case "skills":
                errList.addAll(ValidateSkill.getErrorMapForAllfields(request.getParameter("id"), username));
                // Generate success message depending upon the type of request OR give a list of errors
                if(errList.isEmpty()){
                    request.setAttribute("sucessMessage", "Skill added successfully");
                } else{
                    request.setAttribute("currentTab", "add-skills-cta");
                }
               
                break;
                
            case "education":
                String institution = request.getParameter("institution");
                String education_lvl = request.getParameter("education-lvl");
                String subject = request.getParameter("subject");
                String start_date = request.getParameter("start-date");
                String end_date = request.getParameter("end-date");

                errList.addAll(ValidateEducation.getErrorMapForAllfields(institution, education_lvl, subject, start_date, end_date));
                
                // Prepare education object here itself, if error then used in jsp if NO ERROR, used in data access class
                ValidateEducation.prepareResponse(request, institution, education_lvl, subject);

                break;
                
                case "workHistory":
                String company = request.getParameter("company");
                String title = request.getParameter("title");
                String start_date_work = request.getParameter("start-date");
                String end_date_work = request.getParameter("end-date");
                String reference = request.getParameter("reference");

                errList.addAll(ValidateWorkHistory.getErrorMapForAllfields(company, title, start_date_work, end_date_work, reference));
                 ValidateWorkHistory.prepareResponse(request, company, title, reference);
                break;

        }
        return errList;
    
    }
    public final ArrayList<Skill> getAllSkills(){
        return psdb.getAllSkills();
    }

    private final boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
}
