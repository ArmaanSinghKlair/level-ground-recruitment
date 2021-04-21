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
import validation.ValidateRole;
import validation.ValidateSkill;
import validation.ValidateWorkHistory;

/**
 * Contains various methods to perform profile related services and actions for
 * the different users in our system.
 *
 * @author 839645
 * @version 1.0
 */
public final class ProfileServices {

    private final ProfileServicesDB psdb = new ProfileServicesDB();

    /**
     * Performs the appropriate page action based on the request from the
     * front-end.
     *
     * @param request request from the front-end
     * @param username username of the logged in user
     * @return ArrayList containing any errors
     */
    public final ArrayList<String> profilePageAction(HttpServletRequest request, String username) {
        ArrayList<String> errList = new ArrayList<>();
        // Basic parameters needed to identify request
        String submit = request.getParameter("submit");
        String form_name = request.getParameter("form_name");
        String id = request.getParameter("id");
        HttpSession sess = request.getSession(false);

        if (isEmpty(submit) || (isEmpty(id) && submit.equals("delete")) || isEmpty(username)) {
            errList.add("An error occured. Please reload and try again");
        }
        if (errList.size() > 0) {
            return errList;
        }

        switch (submit) {
            case "deleteCandidate":
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
                    sess = request.getSession(false);
                    String currentUsername = request.getParameter("currentUsername");
                    if (currentUsername != null && !currentUsername.equals("") && !username.equals(currentUsername)) {
                        sess.setAttribute("username", currentUsername);
                    }
                    errList = psdb.edit(request, username);
                }
                break;

        }
        return errList;

    }

    /**
     * VALIDATE requests for create action on profile features
     *
     * @param request request from front-end
     * @param username username of logged in user
     * @return ArrayList containing any errors that occurred
     */
    private final ArrayList<String> validateNewFeature(HttpServletRequest request, String username) {
        String form_name = request.getParameter("form_name");
        ArrayList<String> errList = new ArrayList<String>();

        switch (form_name) {
            case "roles":
                errList.addAll(ValidateRole.getErrorMapForAllfields(request.getParameter("id"), username));
                // Generate success message depending upon the type of request OR give a list of errors
                if (errList.isEmpty()) {
                    request.setAttribute("sucessMessage", "Role added successfully");
                } else {
                    request.setAttribute("currentTab", "add-roles-cta");
                }
                ValidateRole.prepareResponse(request);
                break;
            case "skills":
                errList.addAll(ValidateSkill.getErrorMapForAllfields(request.getParameter("id"), username));
                // Generate success message depending upon the type of request OR give a list of errors
                if (errList.isEmpty()) {
                    request.setAttribute("sucessMessage", "Skill added successfully");
                } else {
                    request.setAttribute("currentTab", "add-skills-cta");
                }
                ValidateSkill.prepareResponse(request);
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

    /**
     * VALIDATE requests for edit action on profile features
     *
     * @param request request from front-end
     * @param username username of logged in user
     * @return ArrayList containing any errors that occurred
     */
    private final ArrayList<String> validateEditFeature(HttpServletRequest request, String username) {
        String form_name = request.getParameter("form_name");
        ArrayList<String> errList = new ArrayList<>();

        switch (form_name) {
            case "roles":
                String ID = request.getParameter("candidateRole");

                if (isEmpty(ID)) {
                    errList.add("Something went wrong, Please reload and try again");
                    break;
                }
                errList.addAll(ValidateRole.getErrorMapForAllfields(ID, username));
                ValidateRole.prepareResponseForEdit(request);
                break;

            case "skills":
                ID = request.getParameter("candidateSkill");

                if (isEmpty(ID)) {
                    errList.add("Something went wrong, Please reload and try again");
                    break;
                }
                errList.addAll(ValidateSkill.getErrorMapForAllfields(ID, username));
                ValidateSkill.prepareResponseForEdit(request);
                break;

            case "education":
                ID = request.getParameter("id");
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
                username = request.getParameter("currentUsername");
                String password = request.getParameter("password");
                String password_repeat = request.getParameter("password-repeat");
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String phoneNo = request.getParameter("phoneNo");
                String currentPassword = request.getParameter("currentPassword");
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

                ValidateCandidate.prepareResponseForEdit(request, password, firstName, lastName, email, phoneNo, username, about, withPassword);
                break;

        }
        return errList;

    }

    /**
     * Loads the appropriate profile based on the user type.
     *
     * @param request request from the front-end
     */
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

    /**
     * Creates a profile for either a Candidate, Business Client, or an Advisor.
     *
     * @param request request from the front-end
     * @return ArrayList containing any errors that occurred
     */
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

    /**
     * Return all skills from the database.
     *
     * @return ArrayList of Skills that matches the search query
     */
    public final ArrayList<Skill> getAllSkills() {
        return psdb.getAllSkills();
    }

    /**
     * Return all roles from the database.
     *
     * @return ArrayList of Roles that matches the search query
     */
    public final ArrayList<Role> getAllRoles() {
        return psdb.getAllRoles();
    }

    /**
     * Return a BusinessClient that matches the specified id.
     *
     * @param id id to search by
     * @return BusinessClient that matches the search query
     */
    public final BusinessClient getBusinessClientByClientID(int id) {
        return psdb.getBusinessClientByClientID(id);
    }

    /**
     * Return a Candidate that matches the specified id.
     *
     * @param id id to search by
     * @return Candidate that matches the search query
     */
    public final Candidate getCandidateByID(int id) {
        return psdb.getCandidateByID(id);
    }

    /**
     * Retrieve the appropriate application for an Advisor that matches the job
     * id and the candidate id
     *
     * @param jobID job posting id
     * @param canID candidate id
     * @return Application that matches the search query
     */
    public final Application getApplicationForAdvisor(int jobID, int canID) {
        return psdb.getApplicationForAdvisor(jobID, canID);
    }

    /**
     * Retrieve a list of job postings for an Advisor that matches the business
     * client id and the advisor id.
     *
     * @param bcID business client id
     * @param adID advisor id
     * @return ArrayList of JobPostings that matches the search query
     */
    public final ArrayList<JobPosting> getJobsForAdvisor(int bcID, int adID) {
        return psdb.getJobsForAdvisor(bcID, adID);
    }

    /**
     * Retrieve a list of job postings for a business client that matches the
     * BusinessClient object.
     *
     * @param id BusinessClient object to search by
     * @return ArrayList of JobPostings that match the search query
     */
    public final ArrayList<JobPosting> getClientJobPostings(BusinessClient id) {
        return psdb.getClientJobPostings(id);
    }

    /**
     * Retrieve job postings that match an Advisor object.
     *
     * @param id Advisor object to search by
     * @return ArrayList of JobPostings that match the search query
     */
    public final ArrayList<JobPosting> getJobpostingsByAdvisorID(Advisor id) {
        return psdb.getJobpostingsByAdvisorID(id);
    }

    /**
     * Retrieve applications by the specified JobPosting object.
     *
     * @param id JobPosting object to search by
     * @return ArrayList of Applications that match the search query
     */
    public final ArrayList<Application> getApplicationsByJobpostingID(JobPosting id) {
        return psdb.getApplicationsByJobpostingID(id);
    }

    /**
     * Retrieves an Application that matches both the job posting id and the
     * candidate id.
     *
     * @param jpID job posting id
     * @param canID candidate id
     * @return Application that matches the search query
     */
    public final Application getApplicationByBothID(int jpID, int canID) {
        return psdb.getApplicationByBothID(jpID, canID);
    }

    /**
     * Used to modify an existing BusinessClient profile.
     *
     * @param company company of the BusinessClient
     * @param username username of the BusinessClient
     * @param email email of the BusinessClient
     * @param phone phone of the BusinessClient
     * @param address address of the BusinessClient
     * @param website website of the BusinessClient
     * @param description description of the BusinessClient
     * @param bc BusinessClient
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> editBusinessClientProfile(String company, String username, String email, String phone, String address, String website, String description, BusinessClient bc) {
        return psdb.editBusinessClientProfile(company, username, email, phone, address, website, description, bc);
    }

    /**
     * Used to modify and existing JobPosting.
     *
     * @param title title of the Job Posting
     * @param status status of the Job Posting
     * @param description description of the Job Posting
     * @param requirements requirements of the Job Posting
     * @param sWage wage of the Job Posting
     * @param location location of the Job Posting
     * @param sDate start date of the Job Posting
     * @param eDate end date of the Job Posting
     * @param jp JobPosting
     * @return ArrayList containing any errors that occurred
     */
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

    /**
     * Updates the Business Client password.
     *
     * @param password new password
     * @param bc BusinessClient to update
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> setNewClientPassword(String password, BusinessClient bc) {
        return psdb.setNewClientPassword(password, bc);
    }

    /**
     * Deletes an application that matches the specified Application object.
     *
     * @param ap Application object to search by
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> deleteApplicationByID(Application ap) {
        return psdb.deleteApplicationByID(ap);
    }

    /**
     * Deletes a business client that matches the specified username.
     *
     * @param username username to search by
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> deleteBusinessClient(String username) {
        return psdb.deleteBusinessClient(username);
    }

    /**
     * Used to check if a specific field is empty or not.
     *
     * @param field field to be checked
     * @return boolean that determines if the field is empty or not
     */
    private final boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }

}
