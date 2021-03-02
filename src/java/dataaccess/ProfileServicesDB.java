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
import problemdomain.CandidateSkill;
import problemdomain.Education;
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
                //returnObj = CandidateSkill.class;
                break;
        }
        return error;
    }
    
    private Class getFeatureClass(String form_name){
        switch(form_name){
            case "skills":
                return null;
            case "workHistory":
                return WorkHistory.class;
            case "education":
                return Education.class;
        }
        return null;
    }
    
}
