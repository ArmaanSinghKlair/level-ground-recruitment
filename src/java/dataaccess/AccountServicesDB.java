/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import problemdomain.Candidate;
import util.DBUtil;
import util.PasswordUtil;

public class AccountServicesDB {
    public final HashMap<String,String> createCandidateProfile(String username,String password,String firstName,String lastName, String email, String phoneNo){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        HashMap<String,String> errMap = new HashMap<>();

        try{
            if(this.doesUserExist(em, "canUsername", username)){
                errMap.put("canUsername", "Username already Exists");
                return errMap;
            }
            Candidate c = new Candidate();
            c.setCanUsername(username);
            c.setCanEmail(email);
            c.setCanPassword(PasswordUtil.hashPassword(password));
            c.setCanfirstName(firstName);
            c.setCanlastName(lastName);
            c.setCanPhoneNo(phoneNo);
            trans.begin();
                em.persist(c);
            trans.commit();
            return null;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
            errMap.put("system", ex.getMessage());
            return errMap;
        } finally{
            if(trans.isActive())
                trans.rollback();
            em.close();
        }
    }
    
    /**
     * Checks to see if user exists -- does not alter the EntityManager in any way so em can passed by reference
     * @param em Entity Manager
     * @param attributeName Name of the parameter by which user wants to check 
     * @param attributeValue Value of that parameter 
     * @return Boolean indicating whether user exists
     */
    public final boolean doesUserExist(EntityManager em,String attributeName, String attributeValue){
        List<Candidate> q = em.createNamedQuery("Candidate.findBy"+attributeName.substring(0, 1).toUpperCase()+ attributeName.substring(1), Candidate.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }
}
