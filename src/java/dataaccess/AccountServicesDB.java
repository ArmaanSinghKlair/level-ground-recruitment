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
import problemdomain.Education;
import problemdomain.JobPosting;
import problemdomain.Skill;
import problemdomain.WorkHistory;
import strategies.authentication.AdvisorAuthentication;
import strategies.authentication.Authentication;
import strategies.authentication.BusinessClientAuthentication;
import strategies.authentication.CandidateAuthentication;
import util.DBUtil;
import util.PasswordUtil;

public class AccountServicesDB {

    private EntityManager em;
    private EntityTransaction trans;

    private void initialize() {
        em = DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }

    public final ArrayList<String> createCandidateProfile(String username, String password, String firstName, String lastName, String email, String phoneNo) {
        initialize();

        ArrayList<String> errList = new ArrayList<>();

        try {
            //Checking to see if User already exists
            if (this.doesCandidateExist(em, "canUsername", username)) {
                errList.add("Username already Exists");
                return errList;
            } else if (doesCandidateExist(em, "canEmail", email)) {
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
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }
    }

    public final ArrayList<String> createBusinessClientProfile(String username, String password, String company, String email, String phoneNo) {
        initialize();

        ArrayList<String> errList = new ArrayList<>();

        try {
            //Checking to see if User already exists
            if (this.doesClientExist(em, "busClientUsername", username)) {
                errList.add("Username already Exists");
                return errList;
            } else if (doesClientExist(em, "busClientEmail", email)) {
                errList.add("Email already exists");
                return errList;
            }

            BusinessClient bc = new BusinessClient();
            bc.setBusClientUsername(username.toLowerCase());
            bc.setBusClientEmail(email);
            bc.setBusClientPassword(PasswordUtil.hashPassword(password));
            bc.setBusClientCompany(company);
            bc.setBusClientPhone(phoneNo);

            trans.begin();
            em.persist(bc);
            trans.commit();

            return null;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
            errList.add("System error. Please check logs");
            return errList;
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }
    }

    public final ArrayList<String> createJobPosting(String title, String requirements, Date startDate, Date endDate, String status, String description) {
        initialize();
        ArrayList<String> errList = new ArrayList<>();

        try {
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
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }
    }

    public final String doesEducationExist(String username, String ID) {
        String err = null;
        try {
            Education e = em.find(Education.class, Integer.parseInt(ID));
            if (e == null) {
                err = "Education does not exist";
            } else {
                if (username != null) {
                    Candidate c = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class).setParameter("canUsername", username).getSingleResult();
                    if (!c.getEducationList().contains(e)) {
                        return "This education record does not belong to you";
                    }
                }
            }

        } finally {
            em.close();
            if (trans.isActive()) {
                trans.rollback();
            }
            return err;
        }

    }

    public final String doesWorkHistoryExist(String username, String ID) {
        String err = null;
        try {
            WorkHistory e = em.find(WorkHistory.class, Integer.parseInt(ID));
            if (e == null) {
                err = "Work History does not exist";
            } else {
                if (username != null) {
                    Candidate c = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class).setParameter("canUsername", username).getSingleResult();
                    if (!c.getWorkHistoryList().contains(e)) {
                        return "This work history record does not belong to you";
                    }
                }
            }

        } finally {
            em.close();
            if (trans.isActive()) {
                trans.rollback();
            }
            return err;
        }

    }

    /**
     * Authenticates a user. The trick here is to hash the input password before
     * comparing it to the input password
     *
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
        } catch (NoResultException e) {
            errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }

        return errList;

    }

    private Authentication getAuthObject(String userType) {
        switch (userType) {
            case "candidate":
                return new CandidateAuthentication(em);
            case "businessClient":
                return new BusinessClientAuthentication(em);
            case "admin":
                return new AdvisorAuthentication(em);
        }
        return null;
    }

    /**
     * Authenticates a user. The trick here is to hash the input password before
     * comparing it to the input password
     *
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
            //System.out.println("INPUT = " + hashedInputPassword + " and db = " + businessClient.getBusClientPassword());
            if (hashedInputPassword.equals(businessClient.getBusClientPassword())) {
                return null;
            } else {
                errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
            }

        } catch (NoResultException e) {
            errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }

        return errList;

    }

    /**
     * Authenticates a user. The trick here is to hash the input password before
     * comparing it to the input password
     *
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
            if (hashedInputPassword.equals(advisor.getAdvisorPassword())) {
                return null;
            } else {
                errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
            }

        } catch (NoResultException e) {
            errList = new ArrayList<>(Arrays.asList(new String[]{"Invalid Username or password"}));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }

        return errList;

    }

    public final Candidate getCandidateByUsername(String username) {
        initialize();
        try {
            if (!doesCandidateExist(em, "canUsername", username)) {
                return null;
            }
            TypedQuery<Candidate> q = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class);
            q.setParameter("canUsername", username);

            Candidate c = q.getSingleResult();
            em.refresh(c);
            return c;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public final Skill getSkillById(String id) {
        initialize();
        try {
            if (!this.doesSkillExist(id)) {
                return null;
            }
            TypedQuery<Skill> q = em.createNamedQuery("Skill.findBySkillID", Skill.class);
            q.setParameter("skillID", Integer.parseInt(id));

            Skill s = q.getSingleResult();
            return s;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public final BusinessClient getBusinessClientByUsername(String username){
        initialize();
        try{
            if(!doesClientExist(em,"busClientUsername",username)){
                return null;
            }
            TypedQuery<BusinessClient> q = em.createNamedQuery("BusinessClient.findByBusClientUsername", BusinessClient.class);
            q.setParameter("busClientUsername", username);

            BusinessClient bc = q.getSingleResult();
            em.refresh(bc);
            return bc;
        }catch(Exception e){
            return null;
        } finally {
            em.close();
        }
    }

    public final Advisor getAdvisorByUsername(String username){
        initialize();
        try{
            if(!doesAdvisorExist(em,"advisorUsername",username)){
                return null;
            }
            TypedQuery<Advisor> q = em.createNamedQuery("Advisor.findByAdvisorUsername", Advisor.class);
            q.setParameter("advisorUsername", username);

            Advisor a = q.getSingleResult();
            em.refresh(a);
            return a;
        }catch(Exception e){
            return null;
        }finally{
            em.close();
        }
    }
    
    public final JobPosting getJobpostingByID(int id){
        initialize();
        try{
            if(!doesJobPostingExist(em,"jobpostingID",id)){
                return null;
            }
            TypedQuery<JobPosting> q = em.createNamedQuery("JobPosting.findByJobpostingID", JobPosting.class);
            q.setParameter("jobpostingID", id);

            JobPosting jp = q.getSingleResult();
            em.refresh(jp);
            return jp;
        }catch(Exception e){
            return null;
        }finally{
            em.close();
        }
    }

    /**
     * Checks to see if user exists -- does not alter the EntityManager in any
     * way so em can passed by reference
     *
     * @param em Entity Manager
     * @param attributeName Name of the parameter by which user wants to check
     * @param attributeValue Value of that parameter
     * @return Boolean indicating whether user exists
     */
    public final boolean doesCandidateExist(EntityManager em, String attributeName, String attributeValue) {
        List<Candidate> q = em.createNamedQuery("Candidate.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), Candidate.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }

    public final boolean doesClientExist(EntityManager em, String attributeName, String attributeValue) {
        List<BusinessClient> q = em.createNamedQuery("BusinessClient.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), BusinessClient.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }

    public final boolean doesAdvisorExist(EntityManager em, String attributeName, String attributeValue) {
        List<Advisor> q = em.createNamedQuery("Advisor.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), Advisor.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }
    
    public final boolean doesJobPostingExist(EntityManager em, String attributeName, int attributeValue) {
        List<JobPosting> q = em.createNamedQuery("JobPosting.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), JobPosting.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }

    public boolean doesSkillExist(String id) {
        if (em == null || !em.isOpen()) {
            initialize();
        }

        return em.find(Skill.class, Integer.parseInt(id)) != null;
    }
}
