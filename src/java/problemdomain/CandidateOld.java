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
 * @version 2/7/2021
 */
public class CandidateOld {
    
    private ArrayList<String> workHistory;
    private ArrayList<String> education;
    private String name;
    private String email;
    private String phoneNumber;
    private int id;
    private ArrayList<String> keySkills;
    private ArrayList<String> interestedRoles;
    private Boolean placed = false;
    private String username;
    private String password;

    public CandidateOld(ArrayList<String> workHistory, ArrayList<String> education, String name, String email, String phoneNumber) {
        this.workHistory = workHistory;
        this.education = education;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    //Kane: SHOULD I ADD A RETURN STRING LIKE "WORK HISTORY UPDATED"?
    public void addWorkHistory(String work) {
        int sizeBefore = workHistory.size();
        workHistory.add(work);
        int sizeAfter = workHistory.size();
        Boolean has = workHistory.contains(work);
        
        if(sizeAfter > sizeBefore && has) {
            
        } else {
            
        }
      
    }
    
    public void removeWorkHistory(String work) {
        int sizeBefore = workHistory.size();
        workHistory.remove(work);
        int sizeAfter = workHistory.size();
        Boolean has = workHistory.contains(work);
        
        if(sizeAfter < sizeBefore && !has) {
            
        } else {
            
        }
          
    }
    
    public ArrayList<String> getWorkHistory() {
        return workHistory;
    }
    
    public void clearWorkHistory(){
        workHistory.clear();
    }
    
    public void addEducation(String newEducation) {
        int sizeBefore = education.size();
        education.add(newEducation);
        int sizeAfter = education.size();
        Boolean has = education.contains(newEducation);
        
        if(sizeAfter > sizeBefore && has) {
            
        } else {
            
        }
      
    }
    
    public void removeEducation(String oldEducation) {
        int sizeBefore = education.size();
        education.remove(oldEducation);
        int sizeAfter = education.size();
        Boolean has = education.contains(oldEducation);
        
        if(sizeAfter < sizeBefore && !has) {
            
        } else {
            
        }
    }
    
    public ArrayList<String> getEducation() {
        return education;
    }
    
    public void clearEducation(){
        education.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getID() {
        return id;
    }
    
    // Kane: What is the purpose of addPhoneNumber
    // public void addPhoneNumber(String phone)

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void addKeySkill(String skill) {
        int sizeBefore = keySkills.size();
        keySkills.add(skill);
        int sizeAfter = keySkills.size();
        Boolean has = keySkills.contains(skill);
        
        if(sizeAfter > sizeBefore && has) {
            
        } else {
            
        }
    }
    
    public void removeKeySkill(String skill) {
        int sizeBefore = keySkills.size();
        keySkills.remove(skill);
        int sizeAfter = keySkills.size();
        Boolean has = keySkills.contains(skill);
        
        if(sizeAfter < sizeBefore && !has) {
            
        } else {
            
        }
    }
    
    public ArrayList<String> getKeySkills() {
        return keySkills;
    }
    
    public void addInterestedRoles(String role) {
        int sizeBefore = interestedRoles.size();
        interestedRoles.add(role);
        int sizeAfter = interestedRoles.size();
        Boolean has = interestedRoles.contains(role);
        
        if(sizeAfter > sizeBefore && has) {
            
        } else {
            
        }
    }
    
    public void removeInterestedRoles(String role) {
        int sizeBefore = interestedRoles.size();
        interestedRoles.remove(role);
        int sizeAfter = interestedRoles.size();
        Boolean has = interestedRoles.contains(role);
        
        if(sizeAfter < sizeBefore && !has) {
            
        } else {
            
        }
    }
    
    public ArrayList<String> getInterestedRoles() {
        return interestedRoles;
    }
    
    public void setPlaced(Boolean placed) {
        this.placed = placed; 
    }
    
    public Boolean isPlaced(){
        return placed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
