/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Used to validate JobPosting attributes and ensure that they don't break the
 * system.
 *
 * @author 756887
 * @version 1.0
 */
public class ValidateJobPosting {

    private static ArrayList<String> errList;

    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation() {
        errList = new ArrayList<>();
    }

    /**
     * Generates an error map for JobPosting attributes.
     *
     * @param title title of the JobPosting
     * @param requirements requirements of the JobPosting
     * @param startDate start date of the JobPosting
     * @param endDate end date of the JobPosting
     * @param status status of the JobPosting
     * @param description description of the JobPosting
     * @param wage wage of the JobPosting
     * @param location location of the JobPosting
     * @return ArrayList containing any errors that occurred.
     */
    public static ArrayList<String> getErrorMapForAllfields(String title, String requirements, Date startDate, Date endDate, String status, String description, Double wage, String location) {
        startValidation();
        put(validateJobTitle(title));
        put(validateJobRequirements(requirements));
        put(validateJobStartDate(startDate, endDate));
        put(validateJobEndDate(startDate, endDate));
        put(validateJobStatus(status));
        put(validateJobDescription(description));
        put(validateJobWage(wage));
        put(validateJobLocation(location));
        return getErrorMap();
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
     * This checks if the job title is not empty or too long.
     *
     * @param title title to check
     * @return String containing validation results
     */
    public static String validateJobTitle(String title) {
        if (isEmpty(title)) {
            return "Title cannot be empty";
        } else if (title.trim().length() > 45) {
            return "Title cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the job requirements are not empty or too long.
     *
     * @param requirements requirements to check
     * @return String containing validation results
     */
    public static String validateJobRequirements(String requirements) {
        if (isEmpty(requirements)) {
            return "Requirements cannot be empty";
        } else if (requirements.length() > 400) {
            return "Requirements cannot be more than 400 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the start date is before the end date and that the start
     * date is not before today.
     *
     * @param startDate start date to check
     * @param endDate end date to check
     * @return String containing validation results
     */
    public static String validateJobStartDate(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            return "Start date cannot be after end date";
        } else if (startDate.before(new Date())) {
            return "Start date cannot be before current date";
        } else {
            return null;
        }
    }

    /**
     * This checks that the end date is after the start date and that the end
     * date is not before today.
     *
     * @param startDate start date to check
     * @param endDate end date to check
     * @return String containing validation results
     */
    public static String validateJobEndDate(Date startDate, Date endDate) {
        if (endDate.before(startDate)) {
            return "End date cannot be before start date";
        } else if (endDate.before(new Date())) {
            return "End date cannot be before current date";
        } else {
            return null;
        }
    }

    /**
     * This checks that the job status is not empty or too long.
     *
     * @param status status to check
     * @return String containing validation results
     */
    public static String validateJobStatus(String status) {
        if (isEmpty(status)) {
            return "Status cannot be empty";
        } else if (status.trim().length() > 45) {
            return "Status cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the job description is not empty or too long.
     *
     * @param description description to check
     * @return String containing validation results
     */
    public static String validateJobDescription(String description) {
        if (isEmpty(description)) {
            return "Description cannot be empty";
        } else if (description.length() > 400) {
            return "Description cannot be more than 400 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the wage is not empty and that the wage is not negative.
     *
     * @param wage wage to be checked
     * @return String containing validation results
     */
    public static String validateJobWage(Double wage) {
        if (wage == 0) {
            return "Wage cannot be empty";
        } else if (wage < 0) {
            return "Wage cannot be negative";
        } else {
            return null;
        }
    }

    /**
     * This checks that the job location is not empty or too long.
     *
     * @param location location to be checked
     * @return String containing validation results
     */
    public static String validateJobLocation(String location) {
        if (isEmpty(location)) {
            return "Location cannot be empty";
        } else if (location.length() > 45) {
            return "Location cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    /**
     * Used to retrieve the error map.
     *
     * @return ArrayList containing any errors that may have occurred
     */
    public static ArrayList<String> getErrorMap() {
        if (errList.isEmpty()) {
            return null;
        } else {
            return errList;
        }
    }

    /**
     * Determines if the specific field is empty.
     *
     * @param field field to check
     * @return boolean representing if the field is empty or not
     */
    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }
}
