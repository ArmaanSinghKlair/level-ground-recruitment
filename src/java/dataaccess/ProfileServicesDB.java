/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import problemdomain.Candidate;
import problemdomain.CandidateSkill;
import problemdomain.Education;
import problemdomain.Skill;
import problemdomain.WorkHistory;
import util.DBUtil;

/**
 *
 * @author 839645
 */
public final class ProfileServicesDB {
    private EntityManager em;
    private EntityTransaction trans;
    
    private void initialize(){
        em =DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }
    
    public final ArrayList<Skill> getAllSkills(){
        initialize();
        try{
            ArrayList<Skill> skills = new ArrayList(em.createNamedQuery("Skill.findAll",Skill.class).getResultList());
            return skills;
        }finally{
            em.close();
        }
    }
    
    public final ArrayList<String> add(HttpServletRequest request, String username){
        initialize();
        try{
            trans.begin();
            // Gets appropriate feature depending upon form parameters
            Object feature = getNewFeature(request, username);
            // Checking to see if its null
            if(feature != null)
                em.persist(feature);
            trans.commit();
        } finally{
            em.close();
        }
        return null;
    }
    public final ArrayList<String> edit(HttpServletRequest request, String username){
        initialize();
        try{
            trans.begin();
            // Gets appropriate feature depending upon form parameters
            Object feature = getNewFeature(request, username);
            // Checking to see if its null
            if(feature != null)
                em.merge(feature);
            trans.commit();
        } finally{
            em.close();
        }
        return null;
    }
    
    private Object getNewFeature(HttpServletRequest request, String username){
        String form_name = request.getParameter("form_name");
        // Required for fetching required data 
        AccountServicesDB asdb = new AccountServicesDB();
        Candidate c = asdb.getCandidateByUsername(username);

        switch(form_name){
            case "skills":
                String skillID = request.getParameter("id");                
                CandidateSkill skill = new CandidateSkill();
                
                // Adds a Candidate to Candidate_skill
                skill.setCandidateID(c);
                
                
                // Adds a Skill to Candidate_skill
                Skill actualSkill = asdb.getSkillById(skillID);
                skill.setSkillID(actualSkill);
                
                
                // Adds an integer skillID
                c.getCandidateSkillList().add(skill);
                return skill;
                
            case "education":
                Education edu = (Education) request.getAttribute("education");
                
                // Adds a Candidate to Candidate_skill

                edu.setCandidateID(c);
                c.getEducationList().add(edu);
               
                return edu;
            case "workHistory":
                WorkHistory wh = (WorkHistory) request.getAttribute("workHistory");
                // Adds a Candidate to Candidate_skill
                wh.setCandidateID(c);
                c.getWorkHistoryList().add(wh);
               
                return wh;
            case "profile":
                return (Candidate) request.getAttribute("candidate");
               
                
                
        }
        return null;
    }
    
   
    // Deletes a profile feature ie. work history, skill etc
    public final ArrayList<String> delete(String form_name, String id, String username){
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        
        try{
            int ID = Integer.parseInt(id); 
            Object feature = em.find(getFeatureClass(form_name), ID);
            
            // ERROR HANDLING START
            if(feature == null){
                errList.add("The item does not exist");
                return errList;
            }
            if(!belongsTo(form_name, em, ID, username)){
                errList.add("The item you are trying to delete not yours");
                return errList;
            }
            
            
            //ERROR HANDLING END
            trans.begin();
            
            em.remove(feature);
            trans.commit();
        } catch(NumberFormatException e){
            errList.add("Invalid data supplied. Please try again");
        } finally{
            if(trans.isActive()){
                trans.rollback();
            }
            em.close();
        }
        
        return errList;
    }
    
     public final boolean deleteCandidate(String username){
        initialize();        
        try{
            TypedQuery<Candidate> q = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class);
            q.setParameter("canUsername", username);            
            Candidate c = q.getSingleResult();
            trans.begin();
            em.remove(c);
            trans.commit();
        } catch(Exception e){
            return false;
        } finally{
            if(trans.isActive()){
                trans.rollback();
            }
            em.close();
        }
        
        return true;
    }
    
     /**
     * This method checks whether the feature to be deleted is infact owned by the user
     * @param form_name Table to be updated
     * @return The class of the table
     */
    private final boolean belongsTo(String form_name, EntityManager em, int id, String username){
        Serializable returnObj;
        boolean error = true;
        switch(form_name){
            case "education":
                returnObj = em.find(Education.class, id);
                if(!((Education)returnObj).getCandidateID().getCanUsername().equals(username)){
                    error = false;
                } 
                break;
                
            case "workHistory":
                returnObj = em.find(WorkHistory.class, id);
                if(!((WorkHistory)returnObj).getCandidateID().getCanUsername().equals(username)){
                    error = false;
                }
                break;
            case "skills":
                returnObj = em.find(CandidateSkill.class, id);
                if(!((CandidateSkill)returnObj).getCandidateID().getCanUsername().equals(username)){
                    error = false;
                }
                break;
        }
        return error;
    }
    
    private Class getFeatureClass(String form_name){
        switch(form_name){
            case "skills":
                return CandidateSkill.class;
            case "workHistory":
                return WorkHistory.class;
            case "education":
                return Education.class;
                
        }
        return null;
    }
    
    
    
    
}
