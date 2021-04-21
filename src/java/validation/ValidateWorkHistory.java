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
 * Used to validate WorkHistory attributes and ensure that they don't break the
 * system.
 *
 * @author 839645
 * @version 1.0
 */
public final class ValidateWorkHistory {

    private static ArrayList<String> errList;
    private static Date start = null;
    private static Date end = null;

    /**
     * Generates an error map for WorkHistory attributes.
     *
     * @param company company of the WorkHistory
     * @param title title of the WorkHistory
     * @param start_date start_date of the WorkHistory
     * @param end_date end_date of the WorkHistory
     * @param reference reference of the WorkHistory
     * @return ArrayList containing any errors that may have occurred
     */
    public static ArrayList<String> getErrorMapForAllfields(String company, String title, String start_date, String end_date, String reference) {
        errList = new ArrayList<>();
        put(checkEmpty(company, title, start_date));
        put(checkDates(start_date, end_date));
        return errList;
    }

    /**
     * Checks if either the company, title, or start_date are empty.
     *
     * @param company company to check
     * @param title title to check
     * @param start_date start_date to check
     * @return String containing validation results
     */
    public static String checkEmpty(String company, String title, String start_date) {
        // Checking empty fields
        if (isEmpty(company.trim()) || isEmpty(title.trim()) || isEmpty(start_date.trim())) {
            return "All fields required";
        } else {
            return null;
        }
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
     * Used to validate the work dates.
     *
     * @param start_date start_date to check
     * @param end_date end_date to check
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
     * Prepares a new WorkHistory to be added to the Candidate's profile.
     *
     * @param request request from the front-end
     * @param company company of the WorkHistory
     * @param title title of the WorkHistory
     * @param reference reference of the WorkHistory
     */
    public static void prepareResponse(HttpServletRequest request, String company, String title, String reference) {
        // Prepare education object here itself, if error then used in jsp if NO ERROR, used in data access class
        WorkHistory wh = new WorkHistory();
        wh.setCompany(company);
        wh.setTitle(title);
        wh.setStartDate(start);
        wh.setEndDate(end);
        wh.setReference(reference);

        // Do this if ANY ERRORS
        if (!errList.isEmpty()) {
            request.setAttribute("currentTab", "add-workHistory-cta");
        }
        request.setAttribute("workHistory", wh);
    }

    /**
     * Prepares an existing WorkHistory to be modified on the Candidate's
     * profile.
     *
     * @param request request from the front-end
     * @param company company of the WorkHistory
     * @param title title of the WorkHistory
     * @param reference reference of the WorkHistory
     */
    public static void prepareResponseForEdit(HttpServletRequest request, String company, String title, String reference) {
        // Prepare education object here itself, if error then used in jsp if NO ERROR, used in data access class
        WorkHistory wh = new WorkHistory();
        wh.setCompany(company);
        wh.setTitle(title);
        wh.setStartDate(start);
        wh.setEndDate(end);
        wh.setReference(reference);
        wh.setWorkhistoryID(Integer.parseInt((String) request.getParameter("id")));

        request.setAttribute("currentTab", "edit-workHistory-cta");
        request.setAttribute("workHistory", wh);

    }

    /**
     * Checks if the specified field is empty.
     *
     * @param field field to check
     * @return boolean representing if the field is empty or not
     */
    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }

}
