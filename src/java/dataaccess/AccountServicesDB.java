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
import problemdomain.Role;
import problemdomain.Skill;
import problemdomain.WorkHistory;
import strategies.authentication.AdvisorAuthentication;
import strategies.authentication.Authentication;
import strategies.authentication.BusinessClientAuthentication;
import strategies.authentication.CandidateAuthentication;
import util.DBUtil;
import util.PasswordUtil;

/**
 * Various account services for different interactions within our database, such
 * as inserting new data into our pre-existing database tables.
 *
 * @author 839645
 * @version 1.0
 */
public class AccountServicesDB {

    private EntityManager em;
    private EntityTransaction trans;

    /**
     * Initialize the EntityManager and EntityTransaction for the various
     * methods within this class.
     */
    private void initialize() {
        em = DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }

    /**
     * Used to create a new Candidate Profile in our database.
     *
     * @param username Username of Candidate
     * @param password Password of Candidate
     * @param firstName First Name of Candidate
     * @param lastName Last Name of Candidate
     * @param email Email of Candidate
     * @param phoneNo Phone number of Candidate
     * @return String ArrayList of any errors that may have occurred.
     */
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
            c.setPlaced(false);
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

    /**
     * Used to create a new Business Client Profile in our database.
     *
     * @param username Username of the Business Client
     * @param password Password of the Business Client
     * @param company Company of the Business Client
     * @param email Email of the Business Client
     * @param phoneNo Phone Number of the Business Client
     * @return String ArrayList of any errors that may have occurred.
     */
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

    /**
     * Used to create a new Advisor Profile in our database.
     *
     * @param username Username of the Advisor
     * @param password Password of the Advisor
     * @param firstName First Name of the Advisor
     * @param lastName Last Name of the Advisor
     * @param email Email of the Advisor
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createAdvisorProfile(String username, String password, String firstName, String lastName, String email) {
        initialize();

        ArrayList<String> errList = new ArrayList<>();

        try {
            //Checking to see if User already exists
            if (this.doesAdvisorExist(em, "advisorUsername", username)) {
                errList.add("Username already Exists");
                return errList;
            } else if (doesAdvisorExist(em, "advisorEmail", email)) {
                errList.add("Email already exists");
                return errList;
            }

            Advisor a = new Advisor();
            a.setAdvisorUsername(username.toLowerCase());
            a.setAdvisorPassword(PasswordUtil.hashPassword(password));
            a.setAdvisorfirstName(firstName);
            a.setAdvisorlastName(lastName);
            a.setAdvisorEmail(email);

            trans.begin();
            em.persist(a);
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

    /**
     * Used to create a new Skill in our database.
     *
     * @param description Skill description.
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createSkill(String description) {
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try {

            //Error checking
            if (description == null || description.equals("")) {
                errList.add("Skill cannot be empty");
                return errList;
            } else if (this.doesSkillDescriptionExist(em, "description", description)) {
                errList.add("Skill already exists");
                return errList;
            } else if (description.length() > 200) {
                errList.add("Skill cannot be longer than 200 characters");
                return errList;
            }

            Skill s = new Skill();
            s.setDescription(description);
            trans.begin();
            em.persist(s);
            trans.commit();

            return null;
        } catch (Exception e) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, e);
            errList.add("System error. Please check logs");
            return errList;
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }
    }

    /**
     * Used to create a new Role in our database.
     *
     * @param description Role Description.
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createRole(String description) {
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try {

            //Error checking
            if (description == null || description.equals("")) {
                errList.add("Role cannot be empty");
                return errList;
            } else if (this.doesRoleExist(em, "description", description)) {
                errList.add("Role already exists");
                return errList;
            } else if (description.length() > 200) {
                errList.add("Role cannot be longer than 200 characters");
                return errList;
            }

            Role r = new Role();
            r.setDescription(description);
            trans.begin();
            em.persist(r);
            trans.commit();

            return null;
        } catch (Exception e) {
            Logger.getLogger(AccountServicesDB.class.getName()).log(Level.SEVERE, null, e);
            errList.add("System error. Please check logs");
            return errList;
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }
    }

    /**
     * Used to create a new Job Posting in our database.
     *
     * @param title Title of the Job Posting
     * @param requirements Requirements of the Job Posting
     * @param startDate Start Date of the Job Posting
     * @param endDate End Date of the Job Posting
     * @param status Status of the Job Posting
     * @param description Description of the Job Posting
     * @param username Username of the Business Client
     * @param wage Wage of the Job Posting
     * @param location Location of the Job Posting
     * @return String ArrayList of any errors that may have occurred.
     */
    public final ArrayList<String> createJobPosting(String title, String requirements, Date startDate, Date endDate, String status, String description, String username, Double wage, String location) {
        BusinessClient bc = getBusinessClientByUsername(username);
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try {
            JobPosting jp = new JobPosting();
            jp.setRequirements(requirements);
            jp.setJobTitle(title);
            jp.setWage(wage);
            jp.setApplicants(0);
            jp.setLocation(location);
            jp.setPostDate(new Date());
            jp.setAdvisorID(em.find(Advisor.class, new AdvisorServicesDB().getNextAdvisorID()));
            jp.setBusinessclientID(bc);
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

    /**
     * Deletes a Job Posting that matches the specified id.
     *
     * @param id id to search by
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> deleteJobPostingByID(int id) {
        initialize();
        ArrayList<String> errList = new ArrayList<>();

        try {
            JobPosting jp = new JobPosting();
            jp = em.find(JobPosting.class, id);
            trans.begin();
            em.remove(jp);
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

    /**
     * Determines if an education exists by matching an education with the
     * specified id.
     *
     * @param username username of the Candidate
     * @param ID id to search by
     * @return String containing validation results
     */
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

    /**
     * Determines if a work history that matches the id exists.
     *
     * @param username username of the Candidate
     * @param ID id to search by
     * @return String containing validation results
     */
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
     * comparing it to the input password.
     *
     * @param username Input username
     * @param password Input password
     * @param userType Input userType
     * @return ArrayList of errors
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

    /**
     * Returns an authentication object for the appropriate user.
     *
     * @param userType the type of user
     * @return Authentication object
     */
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
     * Authenticates a Business Client. The trick here is to hash the input password before
     * comparing it to the input password.
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
     * Authenticates an Advisor. The trick here is to hash the input password before
     * comparing it to the input password.
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

    /**
     * Returns a Candidate object that matches the specified username.
     *
     * @param username username to search by
     * @return Candidate object that matches the search criteria
     */
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

    /**
     * Returns a Skill that matches the specified id.
     *
     * @param id id to search by
     * @return Skill object that matches the search query
     */
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

    /**
     * Returns a Role that matches the specified id.
     *
     * @param id id to search by
     * @return Role object that matches the search query
     */
    public final Role getRoleById(String id) {
        initialize();
        try {
            if (!this.doesRoleExist(id)) {
                return null;
            }
            TypedQuery<Role> q = em.createNamedQuery("Role.findByRoleID", Role.class);
            q.setParameter("roleID", Integer.parseInt(id));

            Role r = q.getSingleResult();
            return r;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Returns a Business Client that matches the specified username.
     *
     * @param username username to search by
     * @return Business Client object that matches the search query
     */
    public final BusinessClient getBusinessClientByUsername(String username) {
        initialize();
        try {
            if (!doesClientExist(em, "busClientUsername", username)) {
                return null;
            }
            TypedQuery<BusinessClient> q = em.createNamedQuery("BusinessClient.findByBusClientUsername", BusinessClient.class);
            q.setParameter("busClientUsername", username);

            BusinessClient bc = q.getSingleResult();
            em.refresh(bc);
            return bc;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Returns an Advisor that matches the specified username.
     *
     * @param username username to search by
     * @return Advisor object that matches the search query
     */
    public final Advisor getAdvisorByUsername(String username) {
        initialize();
        try {
            if (!doesAdvisorExist(em, "advisorUsername", username)) {
                return null;
            }
            TypedQuery<Advisor> q = em.createNamedQuery("Advisor.findByAdvisorUsername", Advisor.class);
            q.setParameter("advisorUsername", username);

            Advisor a = q.getSingleResult();
            em.refresh(a);
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Returns a JobPosting that matches the specified id.
     *
     * @param id id to search by
     * @return JobPosting that matches the search query
     */
    public final JobPosting getJobpostingByID(int id) {
        initialize();
        try {
            if (!doesJobPostingExist(em, "jobpostingID", id)) {
                return null;
            }
            TypedQuery<JobPosting> q = em.createNamedQuery("JobPosting.findByJobpostingID", JobPosting.class);
            q.setParameter("jobpostingID", id);

            JobPosting jp = q.getSingleResult();
            em.refresh(jp);
            return jp;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Checks to see if Candidate exists -- does not alter the EntityManager in
     * any way so em can passed by reference
     *
     * @param em Entity Manager
     * @param attributeName Name of the parameter by which user wants to check
     * @param attributeValue Value of that parameter
     * @return boolean indicating whether user exists
     */
    public final boolean doesCandidateExist(EntityManager em, String attributeName, String attributeValue) {
        List<Candidate> q = em.createNamedQuery("Candidate.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), Candidate.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }

    /**
     * Checks to see if Business Client exists -- does not alter the
     * EntityManager in any way so em can passed by reference
     *
     * @param em EntityManager object
     * @param attributeName name of the attribute
     * @param attributeValue value of the attribute
     * @return boolean indicating whether user exists
     */
    public final boolean doesClientExist(EntityManager em, String attributeName, String attributeValue) {
        List<BusinessClient> q = em.createNamedQuery("BusinessClient.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), BusinessClient.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }

    /**
     * Checks to see if Advisor exists -- does not alter the EntityManager in
     * any way so em can passed by reference
     *
     * @param em EntityManager object
     * @param attributeName name of the attribute
     * @param attributeValue value of the attribute
     * @return boolean indicating whether Advisor exists
     */
    public final boolean doesAdvisorExist(EntityManager em, String attributeName, String attributeValue) {
        List<Advisor> q = em.createNamedQuery("Advisor.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), Advisor.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }

    /**
     * Checks to see if JobPosting exists -- does not alter the EntityManager in
     * any way so em can passed by reference
     *
     * @param em EntityManager object
     * @param attributeName name of the attribute
     * @param attributeValue value of the attribute
     * @return boolean indicating whether JobPosting exists
     */
    public final boolean doesJobPostingExist(EntityManager em, String attributeName, int attributeValue) {
        List<JobPosting> q = em.createNamedQuery("JobPosting.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), JobPosting.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();
    }

    /**
     * Checks to see if Skill description exists -- does not alter the
     * EntityManager in any way so em can passed by reference
     *
     * @param em EntityManager object
     * @param attributeName name of the attribute
     * @param attributeValue value of the attribute
     * @return boolean indicating whether skill description exists
     */
    public final boolean doesSkillDescriptionExist(EntityManager em, String attributeName, String attributeValue) {
        List<Skill> q = em.createNamedQuery("Skill.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), Skill.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();

    }

    /**
     * Checks to see if Skill exists
     *
     * @param id id to search by
     * @return boolean indication whether skill exists
     */
    public boolean doesSkillExist(String id) {
        if (em == null || !em.isOpen()) {
            initialize();
        }

        return em.find(Skill.class, Integer.parseInt(id)) != null;
    }

    /**
     * Checks to see if Role exists
     *
     * @param id id to search by
     * @return boolean indication whether role exists
     */
    public boolean doesRoleExist(String id) {
        if (em == null || !em.isOpen()) {
            initialize();
        }

        return em.find(Role.class, Integer.parseInt(id)) != null;
    }

    /**
     * Checks to see if Role exists -- does not alter the EntityManager in any
     * way so em can passed by reference
     *
     * @param em EntityManager object
     * @param attributeName name of the attribute
     * @param attributeValue value of the attribute
     * @return boolean indicating whether role exists
     */
    public final boolean doesRoleExist(EntityManager em, String attributeName, String attributeValue) {
        List<Role> q = em.createNamedQuery("Role.findBy" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1), Role.class).setParameter(attributeName, attributeValue).getResultList();
        return q != null && !q.isEmpty();

    }
}
