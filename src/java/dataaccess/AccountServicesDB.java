/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import problemdomain.BusinessClient;
import problemdomain.Candidate;
import util.DBUtil;
import util.PasswordUtil;

public class AccountServicesDB {
    public final ArrayList<String> createCandidateProfile(String username,String password,String firstName,String lastName, String email, String phoneNo){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        ArrayList<String> errList = new ArrayList<>();

        try{
            if(this.doesUserExist(em, "canUsername", username)){
                errList.add("Username already Exists");
                return errList;
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
            errList.add("System error. Please check logs");
            return errList;
        } finally{
            if(trans.isActive())
                trans.rollback();
            em.close();
        }
    }
    
    /**
     * Authenticates a user. The trick here is to hash the input password before comparing it to the input password
     * @param username Input username
     * @param password Input password
     * @return Arraylist of errors
     */
    public final ArrayList<String> authenticateCandidate(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Candidate> candidates = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class).setParameter("canUsername", username);
        ArrayList<String> errList = null;
        try {
            Candidate candidate = candidates.getSingleResult();
            String hashedInputPassword = PasswordUtil.hashPassword(password);
            System.out.println("INPUT = "+hashedInputPassword+" and db = "+candidate.getCanPassword());
            if(hashedInputPassword.equals(candidate.getCanPassword())){
                return null;
            } else{
                errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
            }
            
        } catch(NoResultException e){
                errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            em.close();
        }
        
        return errList;

    }
    
    /**
     * Authenticates a user. The trick here is to hash the input password before comparing it to the input password
     * @param username Input username
     * @param password Input password
     * @return Arraylist of errors
     */
    public final ArrayList<String> authenticateBusinessClient(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<BusinessClient> businessClients = em.createNamedQuery("BusinessClient.findByBusClientUsername", BusinessClient.class).setParameter("busClientUsername", username);
        ArrayList<String> errList = null;
        try {
            BusinessClient businessClient = businessClients.getSingleResult();
            String hashedInputPassword = PasswordUtil.hashPassword(password);
            System.out.println("INPUT = "+hashedInputPassword+" and db = "+businessClient.getBusClientPassword());
            if(hashedInputPassword.equals(businessClient.getBusClientPassword())){
                return null;
            } else{
                errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
            }
            
        } catch(NoResultException e){
                errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            em.close();
        }
        
        return errList;

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
