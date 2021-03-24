/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.AccountServicesDB;
import dataaccess.ProfileServicesDB;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Skill;
import strategies.profile.LoadCandidateProfile;
import strategies.profile.LoadProfile;
import validation.ValidateCandidate;
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
            case "deleteCandidate":
                HttpSession sess = request.getSession(false);
                if(psdb.deleteCandidate(username)){
                    sess.invalidate();
                    request.setAttribute("sucessMessage", "Account removed permanently");
                    request.setAttribute("success",true);
                }
                break;
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
            case "edit":
                errList = this.validateEditFeature(request, username);
                // If no errors

              if(errList == null || errList.isEmpty()){
                errList = psdb.edit(request, username);
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
                
                case "profile":
                    username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String password_repeat = request.getParameter("password-repeat");
                    String email = request.getParameter("email");
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String phoneNo = request.getParameter("phoneNo");
                    String currentPassword = request.getParameter("currentPassword");
                    errList = ValidateCandidate.getErrorMapForSignup(username, password, firstName, lastName, email, phoneNo);

                    break;

        }
        return errList;
    
    }
    private final ArrayList<String> validateEditFeature(HttpServletRequest request, String username){
        String form_name = request.getParameter("form_name");
        ArrayList<String> errList = new ArrayList<>();

        switch(form_name){                
            case "education":
                String ID = request.getParameter("id");
                String institution = request.getParameter("institution");
                String education_lvl = request.getParameter("education-lvl");
                String subject = request.getParameter("subject");
                String start_date = request.getParameter("start-date");
                String end_date = request.getParameter("end-date");

                if(isEmpty(ID)){
                    errList.add("Something went wrong, Please reload and try again");
                    break;
                }
                errList.addAll(ValidateEducation.getErrorMapForAllfields(institution, education_lvl, subject, start_date, end_date));
                // Prepare education object here itself, if error then used in jsp if NO ERROR, used in data access class
                ValidateEducation.prepareResponseForEdit(request, institution, education_lvl, subject);
                break;
                
                case "workHistory":
                ID = request.getParameter("id");
                String company = request.getParameter("company");
                String title = request.getParameter("title");
                String start_date_work = request.getParameter("start-date");
                String end_date_work = request.getParameter("end-date");
                String reference = request.getParameter("reference");

                if(isEmpty(ID)){
                    errList.add("Something went wrong, Please reload and try again");
                    break;
                }
                errList.addAll(ValidateWorkHistory.getErrorMapForAllfields(company, title, start_date_work, end_date_work, reference));
                 ValidateWorkHistory.prepareResponseForEdit(request, company, title, reference);
                break;
                
                case "profile":
                    username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String password_repeat = request.getParameter("password-repeat");
                    String email = request.getParameter("email");
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String phoneNo = request.getParameter("phoneNo");
                    String currentPassword = request.getParameter("currentPassword");
                    if(currentPassword != null && currentPassword.trim().length() > 0){
                        if(isEmpty(password) || isEmpty(password_repeat)){
                            errList.add("Password and confim password are required");
                        }else if(!password.equals(password_repeat)){
                            errList.add("Password and confim pasword do not match");
                        }
                    }
                     if(errList == null)
                        errList = new ArrayList<>();
                     boolean withPassword = false;
                     if(currentPassword != null && currentPassword.trim().length()>0){
                        ArrayList<String> validationErr = (ValidateCandidate.validateCurrentPassword(username, currentPassword));
                        withPassword = validationErr == null || validationErr.isEmpty();
                        errList.addAll(validationErr);
                        
                     }
                    
                    ValidateCandidate.prepareResponseForEdit(request, password, firstName, lastName, email, phoneNo, withPassword);
                    break;

        }
        return errList;
    
    }
    
    public void loadProfile(HttpServletRequest request){
        String userType = (String)request.getSession(false).getAttribute("userType");
        LoadProfile p = null;
        switch(userType){
            case "candidate":
                p = new LoadCandidateProfile();
        }
        p.loadProfile(request);
    }
    public final ArrayList<Skill> getAllSkills(){
        return psdb.getAllSkills();
    }

    private final boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
    
    
}
