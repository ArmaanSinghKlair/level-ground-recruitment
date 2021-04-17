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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Advisor;
import problemdomain.Application;
import problemdomain.BusinessClient;
import problemdomain.Candidate;
import problemdomain.JobPosting;
import problemdomain.Role;
import problemdomain.Skill;
import strategies.profile.LoadAdvisorProfile;
import strategies.profile.LoadBusinessClientProfile;
import strategies.profile.LoadCandidateProfile;
import strategies.profile.LoadProfile;
import strategies.registration.RegisterAdvisorProfile;
import strategies.registration.RegisterBusinessClientProfile;
import strategies.registration.RegisterCandidateProfile;
import strategies.registration.RegisterProfile;
import validation.ValidateCandidate;
import validation.ValidateEducation;
import validation.ValidateJobPosting;
import validation.ValidateSkill;
import validation.ValidateWorkHistory;

/**
 *
 * @author 839645
 */
public final class ProfileServices {

    private final ProfileServicesDB psdb = new ProfileServicesDB();
    private final AccountServicesDB asdb = new AccountServicesDB();

    public final ArrayList<String> profilePageAction(HttpServletRequest request, String username) {
        ArrayList<String> errList = new ArrayList<>();
        // Basic parameters needed to identify request
        String submit = request.getParameter("submit");
        String form_name = request.getParameter("form_name");
        String id = request.getParameter("id");

        if (isEmpty(submit) || (isEmpty(id) && submit.equals("delete")) || isEmpty(username)) {
            errList.add("An error occured. Please reload and try again");
        }
        if (errList.size() > 0) {
            return errList;
        }

        switch (submit) {
            case "deleteCandidate":
                HttpSession sess = request.getSession(false);
                if (psdb.deleteCandidate(username)) {
                    sess.invalidate();
                    request.setAttribute("sucessMessage", "Account removed permanently");
                    request.setAttribute("success", true);
                }
                break;
            case "delete":
                errList = psdb.delete(form_name, id, username);
                break;
            case "add":
                //Firstly Validate all CREATE requests
                errList = this.validateNewFeature(request, username);

                // If no errors
                if (errList.isEmpty()) {
                    errList = psdb.add(request, username);
                }
                break;
            case "edit":
                errList = this.validateEditFeature(request, username);
                // If no errors

                if (errList == null || errList.isEmpty()) {
                    errList = psdb.edit(request, username);
                }
                break;

        }
        return errList;

    }

    /**
     * VALIDATE requests for create action on profile features
     *
     * @param request
     * @param username
     * @return
     */
    private final ArrayList<String> validateNewFeature(HttpServletRequest request, String username) {
        String form_name = request.getParameter("form_name");
        ArrayList<String> errList = new ArrayList<String>();

        switch (form_name) {
            case "roles":
                request.setAttribute("sucessMessage", "Role added successfully");
                break;
            case "skills":
                errList.addAll(ValidateSkill.getErrorMapForAllfields(request.getParameter("id"), username));
                // Generate success message depending upon the type of request OR give a list of errors
                if (errList.isEmpty()) {
                    request.setAttribute("sucessMessage", "Skill added successfully");
                } else {
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

    private final ArrayList<String> validateEditFeature(HttpServletRequest request, String username) {
        String form_name = request.getParameter("form_name");
        ArrayList<String> errList = new ArrayList<>();

        switch (form_name) {
            case "education":
                String ID = request.getParameter("id");
                String institution = request.getParameter("institution");
                String education_lvl = request.getParameter("education-lvl");
                String subject = request.getParameter("subject");
                String start_date = request.getParameter("start-date");
                String end_date = request.getParameter("end-date");

                if (isEmpty(ID)) {
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

                if (isEmpty(ID)) {
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
                String currentUsername = request.getParameter("currentUsername");
                String about = request.getParameter("about");

                errList = ValidateCandidate.getErrorMapForEdit(username, firstName, lastName, email, phoneNo);

                if (currentPassword != null && currentPassword.trim().length() > 0) {
                    if (isEmpty(password) || isEmpty(password_repeat)) {
                        errList.add("Password and confim password are required");
                    } else if (!password.equals(password_repeat)) {
                        errList.add("Password and confim pasword do not match");
                    }
                }

                boolean withPassword = false;
                if (currentPassword != null && currentPassword.trim().length() > 0) {
                    ArrayList<String> validationErr = (ValidateCandidate.validateCurrentPassword(username, currentPassword));
                    withPassword = validationErr == null || validationErr.isEmpty();
                    errList.addAll(validationErr);

                }

                ValidateCandidate.prepareResponseForEdit(request, password, firstName, lastName, email, phoneNo, currentUsername, about, withPassword);
                break;

        }
        return errList;

    }

    public void loadProfile(HttpServletRequest request) {
        String userType = (String) request.getSession(false).getAttribute("userType");
        LoadProfile p = null;
        switch (userType) {
            case "candidate":
                p = new LoadCandidateProfile();
                break;
            case "businessClient":
                p = new LoadBusinessClientProfile();
                break;
            case "admin":
                p = new LoadAdvisorProfile();
                break;
        }
        p.loadProfile(request);
    }

    public ArrayList<String> createProfile(HttpServletRequest request) {
        String userType;

        if (request.getParameter("userType") != null) {
            userType = request.getParameter("userType");
        } else {
            HttpSession sess = request.getSession(false);
            userType = (String) sess.getAttribute("userType");
        }

        RegisterProfile rp = null;
        switch (userType) {
            case "candidate":
                rp = new RegisterCandidateProfile();
                break;
            case "businessClient":
                rp = new RegisterBusinessClientProfile();
                break;
            case "admin":
                rp = new RegisterAdvisorProfile();
        }
        return rp.register(request);
    }

    public final ArrayList<Skill> getAllSkills() {
        return psdb.getAllSkills();
    }

    public final ArrayList<Role> getAllRoles() {
        return psdb.getAllRoles();
    }

    public final BusinessClient getBusinessClientByClientID(int id) {
        return psdb.getBusinessClientByClientID(id);
    }

    public final Candidate getCandidateByID(int id) {
        return psdb.getCandidateByID(id);
    }

    public final Application getApplicationForAdvisor(int adID, int bcID) {
        return psdb.getApplicationForAdvisor(adID, bcID);
    }

    public final ArrayList<JobPosting> getJobsForAdvisor(int bcID, int adID) {
        return psdb.getJobsForAdvisor(bcID, adID);
    }

    public final ArrayList<JobPosting> getClientJobPostings(BusinessClient id) {
        return psdb.getClientJobPostings(id);
    }

    public final ArrayList<JobPosting> getJobpostingsByAdvisorID(Advisor id) {
        return psdb.getJobpostingsByAdvisorID(id);
    }

    public final ArrayList<Application> getApplicationsByJobpostingID(JobPosting id) {
        return psdb.getApplicationsByJobpostingID(id);
    }

    public final Application getApplicationByBothID(int jpID, int canID) {
        return psdb.getApplicationByBothID(jpID, canID);
    }

    public final ArrayList<String> editBusinessClientProfile(String company, String username, String email, String phone, String address, String website, String description, BusinessClient bc) {
        return psdb.editBusinessClientProfile(company, username, email, phone, address, website, description, bc);
    }

    public final ArrayList<String> editJobPosting(String title, String status, String description, String requirements, String sWage, String location, String sDate, String eDate, JobPosting jp) {
        ArrayList<String> errList = new ArrayList<>();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDate = parser.parse(sDate);
            Date endDate = parser.parse(eDate);
            Double wage = Double.parseDouble(sWage);

            errList = psdb.editJobPosting(title, status, description, requirements, wage, location, startDate, endDate, jp);
            return errList;
        } catch (NumberFormatException e) {
            errList.add("error parsing wage");
        } catch (ParseException e) {
            errList.add("error parsing date");
        }

        return errList;
    }

    public final ArrayList<String> setNewClientPassword(String password, BusinessClient bc) {
        return psdb.setNewClientPassword(password, bc);
    }
    
    public final ArrayList<String> deleteApplicationByID(Application ap) {
        return psdb.deleteApplicationByID(ap);
    }
    
    public final ArrayList<String> deleteBusinessClient(String username) {
        return psdb.deleteBusinessClient(username);
    }

    private final boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }

}
