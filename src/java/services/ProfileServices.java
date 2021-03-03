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
                String skillID = request.getParameter("id");
                int ID = Integer.parseInt(skillID);
                // Getting to check whether user already has this skill
                Candidate c = asdb.getCandidateByUsername(username);                
                
                if(this.isEmpty(skillID)){
                    errList.add("Skill is required");
                }else{
                    // Checks to see if candidate already has this skill
                    for(CandidateSkill sk: c.getCandidateSkillList()){
                        if(sk.getSkillID().getSkillID() == ID){
                            errList.add("You already added this skill");
                            break;
                        }
                    }
                    // Checks if skill exists in the DATABASE
                    if(!asdb.doesSkillExist(skillID)){
                        errList.add("Selected skill does not exist");
                    }
                }
                
                
                break;
                
            case "education":
                String institution = request.getParameter("institution");
                String education_lvl = request.getParameter("education-lvl");
                String subject = request.getParameter("subject");
                String start_date = request.getParameter("start-date");
                String end_date = request.getParameter("end-date");
                Date start=null;
                Date end=null;

                // Parsing Dates
                 try {
                    start =new SimpleDateFormat("yyyy-MM-dd").parse(start_date);
                    
                    // Since END_DATE is optional
                    if(end_date.trim().length() > 0){
                        end = new SimpleDateFormat("yyyy-MM-dd").parse(end_date);
                        if(start.compareTo(end) >=  0){
                            errList.add("Start date must be before end date");
                        }
                    }
                } catch (ParseException ex) {
                    errList.add("Invalid Date Format");
                }
                 
                 // Checking empty fields
                 if(isEmpty(institution.trim()) || isEmpty(education_lvl.trim()) || isEmpty(subject.trim()) || isEmpty(start_date))
                        errList.add("All fields required");
                
                    
             // Prepare education object here itself, if error then used in jsp if NO ERROR, used in data access class
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
                
                break;
                
                case "workHistory":
                String company = request.getParameter("company");
                String title = request.getParameter("title");
                String start_date_work = request.getParameter("start-date");
                String end_date_work = request.getParameter("end-date");
                String reference = request.getParameter("reference");
                Date start_date_format=null;
                Date end_date_format=null;

                // Parsing Dates
                 try {
                    start_date_format =new SimpleDateFormat("yyyy-MM-dd").parse(start_date_work);
                    
                    // Since END_DATE is optional
                    if(end_date_work.trim().length() > 0){
                        end_date_format = new SimpleDateFormat("yyyy-MM-dd").parse(end_date_work);
                        
                        // Checking if start date is before end date
                        if(start_date_format.compareTo(end_date_format) >=  0){
                            errList.add("Start date must be before end date");
                        }
                    }
                } catch (ParseException ex) {
                    errList.add("Invalid Date Format");
                }
                 
                 // Checking empty fields
                 if(isEmpty(company.trim()) || isEmpty(title.trim()) || isEmpty(start_date_work.trim()))
                        errList.add("All fields required");
                
                    
             // Prepare education object here itself, if error then used in jsp if NO ERROR, used in data access class
                    WorkHistory wh = new WorkHistory();
                    wh.setCompany(company);
                    wh.setTitle(title);
                    wh.setStartDate(start_date_format);
                    wh.setEndDate(end_date_format);
                    wh.setReference(reference);
                    
                    request.setAttribute("workHistory", wh);

                
                // Do this if ANY ERRORS
                if(!errList.isEmpty()){
                    request.setAttribute("currentTab", "add-workHistory-cta");
                }
                
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
