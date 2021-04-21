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
 *
 * @author 839645
 */
public final class ValidateSkill {

    private static String skillID;
    private static final AccountServicesDB asdb = new AccountServicesDB();
    private static String username;
    private static ArrayList<String> errList = new ArrayList<>();

    public static ArrayList<String> getErrorMapForAllfields(String skillId, String Username) {
        errList = new ArrayList<>();
        skillID = skillId;
        username = Username;
        put(validateSkillID());
        put(checkIfExists());
        put(doesSkillExist());
        return errList;
    }

    private static void put(String str) {
        if (str != null) {
            errList.add(str);
        }
    }

    public static String validateSkillID() {
        if (skillID == null) {
            return "Skill is required";
        } else {
            return null;
        }
    }

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

    private static boolean isNumeric(String id) {
        try {
            int ID = Integer.parseInt(id);
            return true;
        } catch (java.lang.NumberFormatException e) {
            return false;
        }
    }

    public static String doesSkillExist() {
        if (!asdb.doesSkillExist(skillID)) {
            return "Selected skill does not exist";
        }
        return null;
    }

    public static void prepareResponse(HttpServletRequest request) {
        CandidateSkill s = new CandidateSkill();
        // Do this if ANY ERRORS
        if (!errList.isEmpty()) {
            request.setAttribute("currentTab", "edit-skills-cta");

        }
        request.setAttribute("canSkill", s);
    }

    public static void prepareResponseForEdit(HttpServletRequest request) {
        CandidateSkill s = new CandidateSkill();
        s.setCanskillID(Integer.parseInt((String) request.getParameter("id")));
        // Do this if ANY ERRORS
        if (!errList.isEmpty()) {
            request.setAttribute("currentTab", "edit-skills-cta");

        }
        request.setAttribute("canSkill", s);

    }

    private final static boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }
}
