/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import problemdomain.BusinessClient;

/**
 * To use this class, first call the startValidation, do your validation and
 * then call getErrorMap
 *
 * @author 839645
 * @version 1.0
 */
public final class ValidateBusinessClient {

    private static ArrayList<String> errList;

    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation() {
        errList = new ArrayList<>();
    }

    //Basic business client validation
    public static ArrayList<String> getErrorMapForAllfields(String username, String password, String company, String email, String phoneNo) {
        startValidation();
        put(validateBusClientUsername(username));
        put(validateBusClientPassword(password));
        put(validateBusClientCompany(company));
        put(validateBusClientEmail(email));
        put(validateBusClientPhoneNo(phoneNo));
        return getErrorMap();
    }

    public static ArrayList<String> validateEdit(String company, String username, String email, String phone, String address, String website, String description) {
        startValidation();
        put(validateBusClientUsername(username));
        put(validateBusClientCompany(company));
        put(validateBusClientEmail(email));
        put(validateBusClientPhoneNo(phone));
        put(validateBusClientAddress(address));
        put(validateBusClientWebsite(website));
        put(validateBusClientDescription(description));
        return getErrorMap();
    }

    /**
     * Appends the appropriate error message into the errList so long as the
     * value is not null.
     *
     * @param errMsg error message
     */
    private static void put(String errMsg) {
        if (errMsg != null) {
            errList.add(errMsg);
        }
    }

    //This checks that the username is not empty or too long
    public static String validateBusClientUsername(String username) {
        if (isEmpty(username)) {
            return "Username cannot be empty";
        } else if (username.trim().length() > 45) {
            return "Username cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    //This checks that the password is not empty or too long
    public static String validateBusClientPassword(String password) {
        if (isEmpty(password)) {
            return "Password cannot be empty";
        } else if (password.length() > 100) {
            return "Password cannot be more than 100 characters";
        } else {
            return null;
        }
    }

    public static String validateBusClientCompany(String company) {

        if (isEmpty(company)) {
            return "Company cannot be empty";
        } else if (company.length() > 100) {
            return "Company cannot be more than 100 characters";
        } else {
            return null;
        }
    }

    //This checks that the email is not empty or too long. It also checks that it is in the correct email format
    public static String validateBusClientEmail(String email) {
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

    //This checks that the phone number is not empty or too long. It also checks that it is in the correct phone number format
    public static String validateBusClientPhoneNo(String phoneNo) {
        if (isEmpty(phoneNo)) {
            return "Phone no cannot be empty";
        } else if (phoneNo.trim().length() > 10) {
            return "Phone no cannot be more than 10 characters";
        } else if (!Pattern.matches("\\d{10}", phoneNo)) {
            return "Phone number requires 10 digits";
        } else {
            return null;
        }
    }

    public static ArrayList<String> getErrorMap() {
        if (errList.isEmpty()) {
            return null;
        } else {
            return errList;
        }
    }

    public static String validateBusClientAddress(String address) {

        if (address.length() > 100) {
            return "Address cannot be more than 100 characters";
        } else {
            return null;
        }
    }

    public static String validateBusClientWebsite(String website) {

        if (website.length() > 100) {
            return "Website cannot be more than 100 characters";
        } else {
            return null;
        }
    }

    public static String validateBusClientDescription(String description) {

        if (description.length() > 255) {
            return "Description cannot be more than 255 characters";
        } else {
            return null;
        }
    }

    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }
}
