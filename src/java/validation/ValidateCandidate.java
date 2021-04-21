/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import problemdomain.Candidate;
import services.AccountServices;
import util.PasswordUtil;

/**
 * To use this class, first call the startValidation, do your validation and
 * then call getErrorMap Another alternate for basic validation is to simply
 * call validateBasicCandidate.
 *
 * @author 839645
 * @version 1.0
 */
public final class ValidateCandidate {

    private static ArrayList<String> errList;

    /**
     * Resets the hash map to an empty map
     */
    public static void startValidation() {
        errList = new ArrayList<>();
    }

    public static ArrayList<String> getErrorMapForSignup(String username, String password, String firstName, String lastName, String email, String phoneNo) {
        startValidation();
        put(validateCanUsername(username));
        put(validateCanPassword(password));
        put(validateCanfirstName(firstName));
        put(validateCanlastName(lastName));
        put(validateCanEmail(email));
        put(validateCanPhoneNo(phoneNo));
        return getErrorMap();
    }

    public static ArrayList<String> getErrorMapForEdit(String username, String firstName, String lastName, String email, String phoneNo) {
        startValidation();
        put(validateCanUsername(username));
        put(validateCanfirstName(firstName));
        put(validateCanlastName(lastName));
        put(validateCanEmail(email));
        put(validateCanPhoneNo(phoneNo));
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

    //This checks that the username is not empty or too long
    public static String validateCanUsername(String username) {
        if (isEmpty(username)) {
            return "Username cannot be empty";
        } else if (username.trim().length() > 45) {
            return "Username cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    //This checks that the password is not empty or too long
    public static String validateCanPassword(String password) {
        if (isEmpty(password)) {
            return "Password cannot be empty";
        } else if (password.length() > 100) {
            return "Password cannot be more than 100 characters";
        } else {
            return null;
        }
    }

    //This checks that the first name is not empty or too long
    public static String validateCanfirstName(String firstName) {
        if (isEmpty(firstName)) {
            return "First name cannot be empty";
        } else if (firstName.length() > 45) {
            return "First name cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    //This checks that the last name is not empty or too long
    public static String validateCanlastName(String lastName) {
        if (isEmpty(lastName)) {
            return "Last name cannot be empty";
        } else if (lastName.length() > 45) {
            return "Last name cannot be more than 45 characters";
        } else {
            return null;
        }
    }

    //This checks that the email is not empty or too long. It also checks that it is in the correct email format
    public static String validateCanEmail(String email) {
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
    public static String validateCanPhoneNo(String phoneNo) {
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

    //This checks that the work history is not empty or too long
    public static String validateWorkHistory(String workHistory) {
        if (!isEmpty(workHistory) && workHistory.trim().length() > 255) {
            return "Work history cannot be more than 255 characters";
        } else {
            return null;
        }
    }

    //This checks that the primary education is not empty or too long
    public static String validatePrimaryEducation(String primaryEducation) {
        if (!isEmpty(primaryEducation) && primaryEducation.trim().length() > 255) {
            return "Primary education cannot be more than 255 characters";
        } else {
            return null;
        }
    }

    //This checks that the secondary education is not empty or too long
    public static String validateSecondaryEducation(String secondaryEducation) {
        if (!isEmpty(secondaryEducation) && secondaryEducation.trim().length() > 255) {
            return "Secondary education cannot be more than 255 characters";
        } else {
            return null;
        }
    }

    //This checks that the certificates are not empty or too long
    public static String validateCertificates(String certificates) {
        if (!isEmpty(certificates) && certificates.trim().length() > 255) {
            return "Certificates cannot be more than 255 characters";
        } else {
            return null;
        }
    }

    //This checks that the key skills are not empty or too long
    public static String validateKeySkills(String keySkills) {
        if (!isEmpty(keySkills) && keySkills.trim().length() > 255) {
            return "Key skills cannot be more than 255 characters";
        } else {
            return null;
        }
    }

    //This checks that the interested roles are not empty or too long
    public static String validateInterestedRoles(String interestedRoles) {
        if (!isEmpty(interestedRoles) && interestedRoles.trim().length() > 255) {
            return "Interested Roles cannot be more than 255 characters";
        } else {
            return null;
        }
    }

    public static ArrayList<String> validateCurrentPassword(String username, String password) {
        ArrayList<String> errList = new AccountServices().authenticate(username, password, "candidate");
        if (errList == null) {
            errList = new ArrayList<>();
        }
        return errList;
    }

    public static void prepareResponseForEdit(HttpServletRequest request, String password, String firstName, String lastName, String email, String phoneNo, String username, String about, boolean withPassword) {
        try {
            Candidate c = new AccountServices().getCandidateByUsername(request.getParameter("username"));
            if (withPassword) {
                c.setCanPassword(PasswordUtil.hashPassword(password));
            }

            c.setCanUsername(username);
            c.setCanEmail(email);
            c.setCanPhoneNo(phoneNo);
            c.setCanfirstName(firstName);
            c.setCanlastName(lastName);
            c.setCanDescription(about);

            if (request.getParameter("placed") != null && request.getParameter("placed").equals("yes")) {
                c.setPlaced(true);
            } else {
                c.setPlaced(false);
            }

            request.setAttribute("candidate", c);
            if (errList != null && !errList.isEmpty()) {
                request.setAttribute("errList", errList);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ValidateCandidate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<String> getErrorMap() {
        if (errList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return errList;
        }
    }

    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }
}
