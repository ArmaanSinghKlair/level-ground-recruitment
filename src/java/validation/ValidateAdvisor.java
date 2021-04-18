/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Used to validate Advisor attributes and ensure that they don't break the
 * system.
 *
 * @author 756887
 * @version 1.0
 */
public class ValidateAdvisor {

    private static ArrayList<String> errList;

    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation() {
        errList = new ArrayList<>();
    }

    /**
     * Advisor validation when an advisor account is created.
     *
     * @param username username of the Advisor
     * @param password password of the Advisor
     * @param firstName first name of the Advisor
     * @param lastName last name of the Advisor
     * @param email email of the Advisor
     * @return String ArrayList of any errors that occurred.
     */
    public static ArrayList<String> getErrorMapForSignup(String username, String password, String firstName, String lastName, String email) {
        startValidation();
        put("advisorUsername", validateAdvisorUsername(username));
        put("advisorPassword", validateAdvisorPassword(password));
        put("advisorfirstName", validateAdvisorfirstName(firstName));
        put("advisorlastName", validateAdvisorlastName(lastName));
        put("advisorEmail", validateAdvisorEmail(email));
        return getErrorMap();
    }

    /**
     * Appends the appropriate error message into the errList so long as the
     * value is not null.
     *
     * @param name name of the parameter
     * @param value error value
     */
    private static void put(String name, String value) {
        if (value != null) {
            errList.add(value);
        }
    }

    /**
     * This checks that the username is not empty or too long.
     *
     * @param username username of the Advisor
     * @return String containing validation result
     */
    public static String validateAdvisorUsername(String username) {
        if (isEmpty(username)) {
            return "Username cannot be empty";
        } else if (username.trim().length() > 45) {
            return "Username cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the password is not empty or too long.
     *
     * @param password password of the Advisor
     * @return String containing validation results
     */
    public static String validateAdvisorPassword(String password) {
        if (isEmpty(password)) {
            return "Password cannot be empty";
        } else if (password.length() > 100) {
            return "Password cannot be more than 100 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the first name is not empty or too long.
     *
     * @param firstName first name of the Advisor
     * @return String containing validation results.
     */
    public static String validateAdvisorfirstName(String firstName) {
        if (isEmpty(firstName)) {
            return "First name cannot be empty";
        } else if (firstName.length() > 45) {
            return "First name cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the last name is not empty or too long
     *
     * @param lastName last name of the Advisor
     * @return String containing validation results
     */
    public static String validateAdvisorlastName(String lastName) {
        if (isEmpty(lastName)) {
            return "Last name cannot be empty";
        } else if (lastName.length() > 45) {
            return "Last name cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    /**
     * This checks that the email is not empty or too long. It also checks that
     * it is in the correct email format.
     *
     * @param email email of the Advisor.
     * @return String containing validation results
     */
    public static String validateAdvisorEmail(String email) {
        if (isEmpty(email)) {
            return "Email cannot be empty";
        } else if (email.trim().length() > 255) {
            return "Email cannot be more than 255 characters";
        } else if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$", email)) {
            return "Invalid email provided";
        } else {
            return null;
        }
    }

    /**
     * Used to get a map of any errors that occurred.
     *
     * @return String ArrayList of any errors that occurred.
     */
    public static ArrayList<String> getErrorMap() {
        if (errList.isEmpty()) {
            return null;
        } else {
            return errList;
        }
    }

    /**
     * Used to check if a specific field is empty or not.
     *
     * @param field String field to be checked
     * @return Boolean that determines if the field is empty or not
     */
    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }
}
