/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemdomain;

import java.util.ArrayList;

/**
 *
 * @author Kane Imler
 * @version 2/11/2021
 */
public class Profile {
    
    private int candidateID;
    private ArrayList<String> keySkills;
    private ArrayList<String> interestedRoles;
    private ArrayList<String> education;
    private ArrayList<String> workHistory;
    private int postingID;
    
    public Profile(int candidateID, ArrayList<String> keySkills, ArrayList<String> interestedRoles, ArrayList<String> education, ArrayList<String> workHistory) {
        this.candidateID = candidateID;
        this.keySkills = keySkills;
        this.interestedRoles = interestedRoles;
        this.education = education;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public ArrayList<String> getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(ArrayList<String> keySkills) {
        this.keySkills = keySkills;
    }

    public ArrayList<String> getInterestedRoles() {
        return interestedRoles;
    }

    public void setInterestedRoles(ArrayList<String> interestedRoles) {
        this.interestedRoles = interestedRoles;
    }

    public ArrayList<String> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<String> education) {
        this.education = education;
    }

    public ArrayList<String> getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(ArrayList<String> workHistory) {
        this.workHistory = workHistory;
    }
    
    public int getPostingID(){
        return postingID;
    }
    
    public void setPostingID(int postingID) {
        this.postingID = postingID;
    }
        
}
