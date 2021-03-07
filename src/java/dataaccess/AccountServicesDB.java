/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import problemdomain.Advisor;
import problemdomain.BusinessClient;
import problemdomain.Candidate;
import problemdomain.JobPosting;
import problemdomain.Skill;
import strategies.authentication.Authentication;
import strategies.authentication.CandidateAuthentication;
import util.DBUtil;
import util.PasswordUtil;

public class AccountServicesDB {
    private EntityManager em;
    private EntityTransaction trans;
    
    private void initialize(){
        em =DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }
    
    public final ArrayList<String> createCandidateProfile(String username,String password,String firstName,String lastName, String email, String phoneNo){
        initialize();
        
        ArrayList<String> errList = new ArrayList<>();

        try{
            //Checking to see if User already exists
            if(this.doesUserExist(em, "canUsername", username)){
                errList.add("Username already Exists");
                return errList;
            }  else if(doesUserExist(em,"canEmail",email)){
                errList.add("Email already exists");
                return errList;
            }
            
            Candidate c = new Candidate();
            c.setCanUsername(username.toLowerCase());
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
    
    public final ArrayList<String> createJobPosting(String title, String requirements, Date startDate, Date endDate, String status, String description){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        ArrayList<String> errList = new ArrayList<>();

        try{
            JobPosting jp = new JobPosting();
            jp.setRequirements(requirements);
            jp.setJobTitle(title);
            jp.setJobDescription(description);
            jp.setJobStatus(status);
            jp.setStartDate(startDate);
            jp.setEndDate(endDate);
            trans.begin();
                em.persist(jp);
            trans.commit();
            return null;
        } catch (Exception ex) {
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
    public final ArrayList<String> authenticate(String username, String password, String userType) {
        initialize();
        ArrayList<String> errList = null;
        try {
            Authentication auth = getAuthObject(userType);
            errList = auth.authenticate(username, password);            
        } catch(NoResultException e){
                errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            em.close();
        }
        
        return errList;

    }
    
    private Authentication getAuthObject(String userType){
        switch(userType){
                case "candidate":
                    return new CandidateAuthentication(em);
                
            }   
        return null;
    }
    /**
     * Authenticates a user. The trick here is to hash the input password before comparing it to the input password
     * @param username Input username
     * @param password Input password
     * @return Arraylist of errors
     */
    public final ArrayList<String> authenticateBusinessClient(String username, String password) {
        initialize();
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
     * Authenticates a user. The trick here is to hash the input password before comparing it to the input password
     * @param username Input username
     * @param password Input password
     * @return Arraylist of errors
     */
    public final ArrayList<String> authenticateAdvisor(String username, String password) {
        initialize();
        TypedQuery<Advisor> advisors = em.createNamedQuery("Advisor.findByAdvisorUsername", Advisor.class).setParameter("advisorUsername", username);
        ArrayList<String> errList = null;
        try {
                  
            Advisor advisor = advisors.getSingleResult();
            String hashedInputPassword = PasswordUtil.hashPassword(password);
            if(hashedInputPassword.equals(advisor.getAdvisorPassword())){
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
    
    public final Candidate getCandidateByUsername(String username){
        initialize();
        try{
            if(!doesUserExist(em,"canUsername",username)){
                return null;
            }
            TypedQuery<Candidate> q = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class);
            q.setParameter("canUsername", username);
            
            Candidate c = q.getSingleResult();
            em.refresh(c);
            return c;
        }catch(Exception e){
            return null;
        }finally{
            em.close();
        }
    }
    
    public final Skill getSkillById(String id){
        initialize();
        try{
            if(!this.doesSkillExist(id)){
                return null;
            }
            TypedQuery<Skill> q = em.createNamedQuery("Skill.findBySkillID", Skill.class);
            q.setParameter("skillID", Integer.parseInt(id));
            
            Skill s = q.getSingleResult();
            return s;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
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
    
    public boolean doesSkillExist(String id){
        if(em == null || !em.isOpen())
            initialize();
        
        return em.find(Skill.class, Integer.parseInt(id)) != null;
    }
}
