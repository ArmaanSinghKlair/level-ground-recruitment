/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.JobPostingServicesDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import problemdomain.JobPosting;

/**
 * Contains various methods to perform job posting related services and actions.
 *
 * @author 839645
 * @version 1.0
 */
public class JobPostingServices {

    private JobPostingServicesDB jpsd = new JobPostingServicesDB();

    /**
     * This method creates an application in the database for the logged in candidate
     * and the job posting they chose.
     * 
     * @param request servlet request
     * @param response servlet response
     */
    public void applyForJob(HttpServletRequest request, HttpServletResponse response) {
        String username = (String) request.getSession().getAttribute("username"); //Candidate username
        ArrayList<String> errList = new ArrayList<String>();
        String id = request.getParameter("jpi");    // Job Posting ID

        if (isEmpty(username) || isEmpty(id)) {
            errList.add("All fields required");
        }

        errList.addAll(jpsd.applyForJob(username, id));
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        if (!errList.isEmpty()) {
            sb.append("\"querySuccessfull\":false,");
            sb.append("\"errors\":");
            sb.append(getArrayString(errList));
        } else {
            sb.append("\"querySuccessfull\":true");
        }
        sb.append("}");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(sb.toString());
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(JobPostingServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Selects a candidate for review by the business client.
     * 
     * @param request servlet request
     * @param response servlet response
     * @return ArrayList of errors
     */
    public ArrayList<String> selectCandidateForReview(HttpServletRequest request, HttpServletResponse response) {
        String applicationID = (String) request.getAttribute("applicationID");
        ArrayList<String> errList = new ArrayList<String>();

        if (isNumeric(applicationID) && !isEmpty(applicationID)) {
            errList.addAll(jpsd.selectCandidateForReview(Integer.parseInt(applicationID)));
        } else {
            errList.add("Unknown error occured. Please try again later");
        }
        return errList;
    }

    /**
     * Selects a candidate for interview.
     * 
     * @param request servlet request
     * @param response servlet response
     * @param applicationID ID of the application to be updated
     * @return ArrayList of errors
     */
    public ArrayList<String> selectCandidateForInterview(HttpServletRequest request, HttpServletResponse response, int applicationID) {

        ArrayList<String> errList = new ArrayList<String>();

        if (applicationID >= 0) {
            errList.addAll(jpsd.selectCandidateForInterview(applicationID, request.getServletContext().getRealPath("/WEB-INF")));
        } else {
            errList.add("Unknown error occured. Please try again later");
        }
        return errList;
    }

    /**
     * Decrements applicants in a job posting.
     * 
     * @param id JobPosting ID
     */
    public final void decrementApplicants(int id) {
        jpsd.decrementApplicants(id);
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

    /**
     * This creates a string out of an input ArrayList
     * 
     * @param arr ArrayList to be converted to a String
     * @return String version of the input array
     */
    private String getArrayString(ArrayList<String> arr) {
        StringBuilder sb = new StringBuilder("[");
        arr.forEach(str -> {
            sb.append("\"").append(str).append("\"").append(",");
        });
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    /**
     * Used to check if a string is numeric or not.
     *
     * @param str String to be checked
     * @return boolean that determines if the field is numeric or not
     */
    private final boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
