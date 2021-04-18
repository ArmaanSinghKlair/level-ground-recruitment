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
import problemdomain.CandidateSkill;
import problemdomain.Role;

/**
 *
 * @author 839645
 */
public final class ValidateRole {

    private static String roleID;
    private static final AccountServicesDB asdb = new AccountServicesDB();
    private static String username;
    private static ArrayList<String> errList = new ArrayList<>();

    public static ArrayList<String> getErrorMapForAllfields(String roleId, String Username) {
        errList = new ArrayList<>();
        roleID = roleId;
        username = Username;
        put(validateRoleID());
        put(checkIfExists());
        put(doesRoleExist());
        return errList;
    }

    private static void put(String str) {
        if (str != null) {
            errList.add(str);
        }
    }

    public static String validateRoleID() {
        if (roleID == null) {
            return "Role is required";
        } else {
            return null;
        }
    }

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

    private static boolean isNumeric(String id) {
        try {
            int ID = Integer.parseInt(id);
            return true;
        } catch (java.lang.NumberFormatException e) {
            return false;
        }
    }

    public static String doesRoleExist() {
        if (!asdb.doesRoleExist(roleID)) {
            return "Selected skill does not exist";
        }
        return null;
    }

    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }
}
