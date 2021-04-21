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
 * Used to validate Education attributes and ensure that they don't break the
 * system.
 *
 * @author 839645
 * @version 1.0
 */
public class ValidateEducation {

    private static ArrayList<String> errList;
    private static Date start = null;
    private static Date end = null;

    /**
     * Generates an error map for Education fields.
     *
     * @param institution institution of the Education
     * @param education_lvl education level of the Education
     * @param subject subject of the Education
     * @param start_date start date of the Education
     * @param end_date end date of the Education
     * @return ArrayList containing any errors that may have occurred
     */
    public static ArrayList<String> getErrorMapForAllfields(String institution, String education_lvl, String subject, String start_date, String end_date) {
        errList = new ArrayList<>();
        put(checkIfEmpty(institution, education_lvl, subject, start_date));
        put(checkDates(start_date, end_date));
        return errList;
    }

    /**
     * Appends the appropriate error message into the errList so long as the
     * value is not null.
     *
     * @param errMsg error value
     */
    private static void put(String errMsg) {
        if (errMsg != null) {
            errList.add(errMsg);
        }
    }

    /**
     * Checks if either the institution, education level, subject, or start date
     * is empty.
     *
     * @param institution institution to check
     * @param education_lvl education level to check
     * @param subject subject to check
     * @param start_date start date to check
     * @return String containing validation results
     */
    public static String checkIfEmpty(String institution, String education_lvl, String subject, String start_date) {
        // Checking empty fields
        if (isEmpty(institution) || isEmpty(education_lvl) || isEmpty(subject) || isEmpty(start_date)) {
            return "All fields required";
        } else {
            return null;
        }
    }

    /**
     * Used to validate the Education dates.
     *
     * @param start_date start date to be checked
     * @param end_date end date to be checked
     * @return String containing validation results
     */
    public static String checkDates(String start_date, String end_date) {
        // Parsing Dates
        try {
            start = new SimpleDateFormat("yyyy-MM-dd").parse(start_date);

            // Since END_DATE is optional
            if (end_date.trim().length() > 0) {
                end = new SimpleDateFormat("yyyy-MM-dd").parse(end_date);
                if (start.compareTo(end) >= 0) {
                    return "Start date must be before end date";
                }
            }
            return null;
        } catch (ParseException ex) {
            return "Invalid date format";
        }

    }

    /**
     * Prepares the Education to be added to the Candidate's profile.
     *
     * @param request request from the front-end
     * @param institution institution of the Education
     * @param education_lvl education level institution of the Education
     * @param subject subject institution of the Education
     */
    public static void prepareResponse(HttpServletRequest request, String institution, String education_lvl, String subject) {

        Education edu = new Education();
        edu.setInstitution(institution);
        edu.setLevel(education_lvl);
        edu.setEndDate(end);
        edu.setStartDate(start);
        edu.setSubject(subject);

        // Do this if ANY ERRORS
        if (!errList.isEmpty()) {
            request.setAttribute("currentTab", "add-education-cta");

        }
        request.setAttribute("education", edu);

    }

    /**
     * Prepares an existing Education to be modified in the Candidate's profile.
     *
     * @param request request from the front-end
     * @param institution institution of the Education
     * @param education_lvl education level institution of the Education
     * @param subject subject institution of the Education
     */
    public static void prepareResponseForEdit(HttpServletRequest request, String institution, String education_lvl, String subject) {
        Education edu = new Education();
        edu.setInstitution(institution);
        edu.setLevel(education_lvl);
        edu.setEndDate(end);
        edu.setStartDate(start);
        edu.setSubject(subject);
        edu.setEducationID(Integer.parseInt((String) request.getParameter("id")));
        // Do this if ANY ERRORS
        if (!errList.isEmpty()) {
            request.setAttribute("currentTab", "edit-education-cta");

        }
        request.setAttribute("education", edu);

    }

    /**
     * Determines if the specific field is empty or not.
     *
     * @param field field to check
     * @return Boolean representing if the field is empty or not
     */
    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }

}
