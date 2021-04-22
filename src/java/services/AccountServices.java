/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.AccountServicesDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import problemdomain.Advisor;
import problemdomain.BusinessClient;
import problemdomain.Candidate;
import problemdomain.JobPosting;
import validation.ValidateAdvisor;
import validation.ValidateBusinessClient;
import validation.ValidateCandidate;
import validation.ValidateJobPosting;

/**
 * Contains various methods to perform account related services and actions such
 * as creating new accounts or entries in our database tables.
 *
 * @author 839645
 * @version 1.0
 */
public class AccountServices {

    private final AccountServicesDB asdb = new AccountServicesDB();
    private final ArrayList<String> userTypes = new ArrayList<>();

    /**
     * Default no-args constructor. Appends the user types of our system into
     * the user types ArrayList.
     */
    public AccountServices() {
        userTypes.add("admin");
        userTypes.add("candidate");
        userTypes.add("businessClient");
    }

    /**
     * Used to create a new Candidate Profile in our database.
     *
     * @param username username of the Candidate
     * @param password password of the Candidate
     * @param password_repeat repeated password of the Candidate
     * @param firstName first name of the Candidate
     * @param lastName last name of the Candidate
     * @param email email of the Candidate
     * @param phoneNo phone number of the Candidate
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> createCandidateProfile(String username, String password, String password_repeat, String firstName, String lastName, String email, String phoneNo) {
        ArrayList<String> errList;
        errList = ValidateCandidate.getErrorMapForSignup(username, password, firstName, lastName, email, phoneNo);

        if (errList == null) {
            errList = new ArrayList<>();
        }
        if (!password.trim().equals(password_repeat.trim())) {
            errList.add("Password doesn\'t match confirm-password");
        }
        if (errList.size() > 0) {
            return errList;
        } else {
            return asdb.createCandidateProfile(username, password, firstName, lastName, email, phoneNo);
        }
    }

    /**
     * Used to create a new Business Client Profile in our database.
     *
     * @param username Username of the Business Client
     * @param password Password of the Business Client
     * @param password_repeat Repeated password of the Business Client
     * @param company Company of the Business Client
     * @param email Email of the Business Client
     * @param phoneNo Phone Number of the Business Client
     * @return String ArrayList of any errors that may have occurred. *
     */
    public final ArrayList<String> createBusinessClientProfile(String username, String password, String password_repeat, String company, String email, String phoneNo) {
        ArrayList<String> errList;
        errList = ValidateBusinessClient.getErrorMapForAllfields(username, password, company, email, phoneNo);

        if (errList == null) {
            errList = new ArrayList<>();
        }
        if (!password.trim().equals(password_repeat.trim())) {
            errList.add("Password doesn\'t match confirm-password");
        }
        if (errList.size() > 0) {
            return errList;
        } else {
            return asdb.createBusinessClientProfile(username, password, company, email, phoneNo);
        }
    }

    /**
     * Used to create a new Advisor Profile in our database.
     *
     * @param username Username of the Advisor
     * @param password Password of the Advisor
     * @param firstName First Name of the Advisor
     * @param lastName Last Name of the Advisor
     * @param email Email of the Advisor
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createAdvisorProfile(String username, String password, String firstName, String lastName, String email) {
        ArrayList<String> errList;
        errList = ValidateAdvisor.getErrorMapForSignup(username, password, firstName, lastName, email);

        if (errList == null) {
            errList = new ArrayList<>();
        }

        if (errList.size() > 0) {
            return errList;
        } else {
            return asdb.createAdvisorProfile(username, password, firstName, lastName, email);
        }
    }

    /**
     * Authenticates a user. The trick here is to hash the input password before
     * comparing it to the input password.
     *
     * @param username Input username
     * @param password Input password
     * @param userType Input userType
     * @return ArrayList of errors
     */
    public final ArrayList<String> authenticate(String username, String password, String userType) {
        ArrayList<String> errList = new ArrayList<>();

        if (isEmpty(username) || isEmpty(password) || isEmpty(userType)) {
            errList.add("All fields required");
        }

        if (!userTypes.contains(userType.trim())) {
            errList.add("Invalid User type");
        }

        if (errList.isEmpty()) {

            return asdb.authenticate(username, password, userType);

        } else {
            return errList;
        }
    }

    /**
     * Used to create a new Skill in our database.
     *
     * @param description Skill description.
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createSkill(String description) {
        ArrayList<String> errList = new ArrayList<>();
        try {
            if (errList.isEmpty()) {
                return asdb.createSkill(description);

            } else {
                return errList;
            }
        } catch (Exception e) {
            errList.add("Unknown error occured. Please try again later.");
        }

        return errList;
    }

    /**
     * Used to create a new Role in our database.
     *
     * @param description Role Description.
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createRole(String description) {
        ArrayList<String> errList = new ArrayList<>();
        try {
            if (errList.isEmpty()) {
                return asdb.createRole(description);

            } else {
                return errList;
            }
        } catch (Exception e) {
            errList.add("Unknown error occured. Please try again later.");
        }

        return errList;
    }

    /**
     * Used to create a new Job Posting in our database.
     *
     * @param title Title of the Job Posting
     * @param requirements Requirements of the Job Posting
     * @param sDate Start Date of the Job Posting
     * @param eDate End Date of the Job Posting
     * @param status Status of the Job Posting
     * @param description Description of the Job Posting
     * @param sWage Wage of the Job Posting
     * @param location Location of the Job Posting
     * @param username Username of the Business Client
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createJobPosting(String title, String requirements, String sDate, String eDate, String status, String description, String sWage, String location, String username) {
        ArrayList<String> errList = new ArrayList<>();
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDate = parser.parse(sDate);
            Date endDate = parser.parse(eDate);
            Double wage = Double.parseDouble(sWage);

            errList = ValidateJobPosting.getErrorMapForAllfields(title, requirements, startDate, endDate, status, description, wage, location);

            if (errList != null) {
                return errList;
            } else {
                return asdb.createJobPosting(title, requirements, startDate, endDate, status, description, username, wage, location);
            }
        } catch (NumberFormatException e) {
            errList.add("error parsing wage");
        } catch (ParseException e) {
            errList.add("error parsing date");
        }

        return errList;

    }

    /**
     * Authenticates a Business Client. The trick here is to hash the input
     * password before comparing it to the input password.
     *
     * @param username Input username
     * @param password Input password
     * @return Arraylist of errors
     */
    public final ArrayList<String> authenticateBusinessClient(String username, String password) {
        ArrayList<String> errList = new ArrayList<>();
        add(errList, ValidateBusinessClient.validateBusClientUsername(username));       //Validate username and get errors IF ANY
        add(errList, ValidateBusinessClient.validateBusClientPassword(password));       //Validate password and get errors IF ANY

        if (errList.isEmpty()) {
            return asdb.authenticateBusinessClient(username, password);
        } else {
            return errList;
        }
    }

    /**
     * Authenticates an Advisor. The trick here is to hash the input password
     * before comparing it to the input password.
     *
     * @param username Input username
     * @param password Input password
     * @return Arraylist of errors
     */
    public final ArrayList<String> authenticateAdvisor(String username, String password) {
        ArrayList<String> errList = new ArrayList<>();
        add(errList, ValidateAdvisor.validateAdvisorUsername(username));       //Validate username and get errors IF ANY
        add(errList, ValidateAdvisor.validateAdvisorPassword(password));       //Validate password and get errors IF ANY

        if (errList.isEmpty()) {
            return asdb.authenticateAdvisor(username, password);
        } else {
            return errList;
        }
    }

    /**
     * Returns a Candidate object that matches the specified username.
     *
     * @param username username to search by
     * @return Candidate object that matches the search criteria
     */
    public final Candidate getCandidateByUsername(String username) {
        return asdb.getCandidateByUsername(username);
    }

    /**
     * Returns a Business Client that matches the specified username.
     *
     * @param username username to search by
     * @return Business Client object that matches the search query
     */
    public final BusinessClient getBusinessClientByUsername(String username) {
        return asdb.getBusinessClientByUsername(username);
    }

    /**
     * Returns an Advisor that matches the specified username.
     *
     * @param username username to search by
     * @return Advisor object that matches the search query
     */
    public final Advisor getAdvisorByUsername(String username) {
        return asdb.getAdvisorByUsername(username);
    }

    /**
     * Returns a JobPosting that matches the specified id.
     *
     * @param id id to search by
     * @return JobPosting that matches the search query
     */
    public final JobPosting getJobpostingByID(int id) {
        return asdb.getJobpostingByID(id);
    }

    /**
     * Deletes a Job Posting that matches the specified id.
     *
     * @param id id to search by
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> deleteJobPostingByID(int id) {
        return asdb.deleteJobPostingByID(id);
    }

    /**
     * Determines if the specified field is empty.
     *
     * @param field field to check
     * @return boolean indicating if field is empty or not
     */
    private final boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }

    /**
     * Appends a value into the errList.
     *
     * @param errList ArrayList of errors
     * @param value value to be added
     */
    private final void add(ArrayList<String> errList, String value) {
        if (value != null) {
            errList.add(value);
        }
    }
}
