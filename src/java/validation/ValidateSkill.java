/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import dataaccess.AccountServicesDB;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import problemdomain.Candidate;
import problemdomain.CandidateSkill;
import problemdomain.Skill;

/**
 * Used to validate Skill attributes and ensure that they don't break the
 * system.
 *
 * @author 839645
 * @version 1.0
 */
public final class ValidateSkill {

    private static String skillID;
    private static final AccountServicesDB asdb = new AccountServicesDB();
    private static String username;
    private static ArrayList<String> errList = new ArrayList<>();

    /**
     * Generates an error map for skill attributes.
     *
     * @param skillId ID of the Skill
     * @param Username username of the Candidate
     * @return
     */
    public static ArrayList<String> getErrorMapForAllfields(String skillId, String Username) {
        errList = new ArrayList<>();
        skillID = skillId;
        username = Username;
        put(validateSkillID());
        put(checkIfExists());
        put(doesSkillExist());
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
     * Validates the skill id.
     *
     * @return String containing validation result
     */
    public static String validateSkillID() {
        if (skillID == null) {
            return "Skill is required";
        } else {
            return null;
        }
    }

    /**
     * Checks if the Candidate currently has this skill.
     *
     * @return String containing validation result
     */
    public static String checkIfExists() {
        Candidate c = asdb.getCandidateByUsername(username);
        if (validateSkillID() == null && isNumeric(skillID)) {
            int ID = Integer.parseInt(skillID);
            //Checks to see if candidate already has this skill
            for (CandidateSkill sk : c.getCandidateSkillList()) {
                if (sk.getSkillID().getSkillID() == ID) {
                    return "You already have this skill";
                }
            }
        }
        return null;

    }

    /**
     * Determines if the id is numeric.
     *
     * @param id ID to check
     * @return Boolean representing if the id is numeric or not.
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
     * Determines if the skill exists in the database.
     *
     * @return String representing validation result
     */
    public static String doesSkillExist() {
        if (!asdb.doesSkillExist(skillID)) {
            return "Selected skill does not exist";
        }
        return null;
    }

    /**
     * Prepares the skill to be added to the Candidate's profile.
     *
     * @param request Request from the front-end
     */
    public static void prepareResponse(HttpServletRequest request) {
        CandidateSkill s = new CandidateSkill();
        // Do this if ANY ERRORS
        if (!errList.isEmpty()) {
            request.setAttribute("currentTab", "edit-skills-cta");

        }
        request.setAttribute("canSkill", s);
    }

    /**
     * Prepares an existing skill to be modified in the Candidate's profile.
     *
     * @param request Request from the front-end
     */
    public static void prepareResponseForEdit(HttpServletRequest request) {
        CandidateSkill s = new CandidateSkill();
        s.setCanskillID(Integer.parseInt((String) request.getParameter("id")));
        // Do this if ANY ERRORS
        if (!errList.isEmpty()) {
            request.setAttribute("currentTab", "edit-skills-cta");

        }
        request.setAttribute("canSkill", s);

    }

    /**
     * Determines if the field passed in is empty.
     *
     * @param field Field to check
     * @return Boolean representing if the field was empty or not.
     */
    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }
}
