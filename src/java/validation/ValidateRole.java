/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import dataaccess.AccountServicesDB;
import java.util.ArrayList;
import problemdomain.Candidate;
import problemdomain.CandidateRole;

/**
 * Used to validate Role attributes and ensure that they don't break the system.
 *
 * @author kentp
 * @version 1.0
 */
public final class ValidateRole {

    private static String roleID;
    private static final AccountServicesDB asdb = new AccountServicesDB();
    private static String username;
    private static ArrayList<String> errList = new ArrayList<>();

    /**
     * Generates an error map for role attributes.
     *
     * @param roleId ID of the Role
     * @param Username username of the Role
     * @return String Arraylist containing any errors that may have occurred
     */
    public static ArrayList<String> getErrorMapForAllfields(String roleId, String Username) {
        errList = new ArrayList<>();
        roleID = roleId;
        username = Username;
        put(validateRoleID());
        put(checkIfExists());
        put(doesRoleExist());
        return errList;
    }

    /**
     * Appends the appropriate error message into the errList so long as the
     * value is not null.
     *
     * @param str error value
     */
    private static void put(String str) {
        if (str != null) {
            errList.add(str);
        }
    }

    /**
     * Validates the role id.
     *
     * @return String containing validation result
     */
    public static String validateRoleID() {
        if (roleID == null) {
            return "Role is required";
        } else {
            return null;
        }
    }

    /**
     * Checks if the role is current associated with the Candidate.
     *
     * @return String containing validation result
     */
    public static String checkIfExists() {
        Candidate c = asdb.getCandidateByUsername(username);
        if (validateRoleID() == null && isNumeric(roleID)) {
            int ID = Integer.parseInt(roleID);
            //Checks to see if candidate already has this skill
            for (CandidateRole cr : c.getCandidateRoleList()) {
                if (cr.getRoleID().getRoleID() == ID) {
                    return "You already have this Role";
                }
            }
        }
        return null;

    }

    /**
     * Determines if the role id is numeric.
     *
     * @param id ID of the Role
     * @return Boolean of whether the id is numeric or not
     */
    private static boolean isNumeric(String id) {
        try {
            int ID = Integer.parseInt(id);
            return true;
        } catch (java.lang.NumberFormatException e) {
            return false;
        }
    }

    /**
     * Ensures the Role actually exists in the database.
     *
     * @return String containing validation result.
     */
    public static String doesRoleExist() {
        if (!asdb.doesRoleExist(roleID)) {
            return "Selected role does not exist";
        }
        return null;
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
