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
 *
 * @author 839645
 */
public class AccountServices {

    private final AccountServicesDB asdb = new AccountServicesDB();
    private final ArrayList<String> userTypes = new ArrayList<>();

    public AccountServices() {
        userTypes.add("admin");
        userTypes.add("candidate");
        userTypes.add("businessClient");
    }

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
                return asdb.createJobPosting(title, requirements, startDate, endDate, status, description, username);
            }
        } catch (NumberFormatException e) {
            errList.add("error parsing wage");
        } catch (ParseException e) {
            errList.add("error parsing date");
        }

        return errList;

    }

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

    public final Candidate getCandidateByUsername(String username) {
        return asdb.getCandidateByUsername(username);
    }
    
    public final BusinessClient getBusinessClientByUsername(String username){
        return asdb.getBusinessClientByUsername(username);
    }

    public final Advisor getAdvisorByUsername(String username){
        return asdb.getAdvisorByUsername(username);
    }
    
    public final JobPosting getJobpostingByID(int id){
        return asdb.getJobpostingByID(id);
    }
    
    private final boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }

    private final void add(ArrayList<String> errList, String value) {
        if (value != null) {
            errList.add(value);
        }
    }
}
