/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Advisor;
import problemdomain.Application;
import problemdomain.BusinessClient;
import problemdomain.Candidate;
import problemdomain.CandidateRole;
import problemdomain.CandidateSkill;
import problemdomain.Education;
import problemdomain.JobPosting;
import problemdomain.Role;
import problemdomain.Skill;
import problemdomain.WorkHistory;
import util.DBUtil;

/**
 * Allows direct access to the database for the different profile services being
 * performed.
 *
 * @author 839645
 * @version 1.0
 */
public final class ProfileServicesDB {

    private EntityManager em;
    private EntityTransaction trans;

    /**
     * Used to initialize the EntityManager.
     */
    private void initialize() {
        em = DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }

    /**
     * Return all skills from the database.
     *
     * @return ArrayList of Skills that matches the search query
     */
    public final ArrayList<Skill> getAllSkills() {
        initialize();
        try {
            ArrayList<Skill> skills = new ArrayList(em.createNamedQuery("Skill.findAll", Skill.class).getResultList());
            return skills;
        } finally {
            em.close();
        }
    }

    /**
     * Return all roles from the database.
     *
     * @return ArrayList of Roles that matches the search query
     */
    public final ArrayList<Role> getAllRoles() {
        initialize();
        try {
            ArrayList<Role> roles = new ArrayList(em.createNamedQuery("Role.findAll", Role.class).getResultList());
            return roles;
        } finally {
            em.close();
        }
    }

    /**
     * Return a BusinessClient that matches the specified id.
     *
     * @param id id to search by
     * @return BusinessClient that matches the search query
     */
    public final BusinessClient getBusinessClientByClientID(int id) {
        initialize();
        try {
            TypedQuery<BusinessClient> q = em.createNamedQuery("BusinessClient.findByBusinessclientID", BusinessClient.class);
            q.setParameter("businessclientID", id);
            BusinessClient bc = q.getSingleResult();
            return bc;
        } finally {
            em.close();
        }
    }

    /**
     * Return a Candidate that matches the specified id.
     *
     * @param id id to search by
     * @return Candidate that matches the search query
     */
    public final Candidate getCandidateByID(int id) {
        initialize();
        try {
            TypedQuery<Candidate> q = em.createNamedQuery("Candidate.findByCandidateID", Candidate.class);
            q.setParameter("candidateID", id);
            Candidate can = q.getSingleResult();
            return can;
        } finally {
            em.close();
        }
    }

    /**
     * Retrieve the appropriate application for an Advisor that matches the job
     * id and the candidate id
     *
     * @param jobID job posting id
     * @param canID candidate id
     * @return Application that matches the search query
     */
    public final Application getApplicationForAdvisor(int jobID, int canID) {
        initialize();
        try {
            TypedQuery<Application> q = em.createQuery("select a from Application a where a.jobpostingID.jobpostingID = :jobID and a.candidateID.candidateID = :canID", Application.class);
            q.setParameter("jobID", jobID);
            q.setParameter("canID", canID);
            Application app = q.getSingleResult();
            return app;
        } finally {
            em.close();
        }
    }

    /**
     * Retrieve a list of job postings for an Advisor that matches the business
     * client id and the advisor id.
     *
     * @param bcID business client id
     * @param adID advisor id
     * @return ArrayList of JobPostings that matches the search query
     */
    public final ArrayList<JobPosting> getJobsForAdvisor(int adID, int bcID) {
        initialize();
        try {
            TypedQuery<JobPosting> q = em.createQuery("select jp from JobPosting jp where jp.businessclientID.businessclientID = :bcID and jp.advisorID.advisorID = :adID", JobPosting.class);
            q.setParameter("adID", adID);
            q.setParameter("bcID", bcID);
            ArrayList<JobPosting> postings = new ArrayList(q.getResultList());
            return postings;
        } finally {
            em.close();
        }
    }

    /**
     * Retrieve a list of job postings for a business client that matches the
     * BusinessClient object.
     *
     * @param id BusinessClient object to search by
     * @return ArrayList of JobPostings that match the search query
     */
    public final ArrayList<JobPosting> getClientJobPostings(BusinessClient id) {
        initialize();
        try {
            TypedQuery<JobPosting> q = em.createNamedQuery("JobPosting.findByBusinessClientID", JobPosting.class);
            q.setParameter("businessclientID", id);
            ArrayList<JobPosting> postings = new ArrayList(q.getResultList());
            return postings;
        } finally {
            em.close();
        }
    }

    /**
     * Retrieve job postings that match an Advisor object.
     *
     * @param id Advisor object to search by
     * @return ArrayList of JobPostings that match the search query
     */
    public final ArrayList<JobPosting> getJobpostingsByAdvisorID(Advisor id) {
        initialize();
        try {
            TypedQuery<JobPosting> q = em.createNamedQuery("JobPosting.findByAdvisorID", JobPosting.class);
            q.setParameter("advisorID", id);
            ArrayList<JobPosting> jobPostings = new ArrayList(q.getResultList());
            return jobPostings;
        } finally {
            em.close();
        }
    }

    /**
     * Retrieve applications by the specified JobPosting object.
     *
     * @param id JobPosting object to search by
     * @return ArrayList of Applications that match the search query
     */
    public final ArrayList<Application> getApplicationsByJobpostingID(JobPosting id) {
        initialize();
        try {
            TypedQuery<Application> q = em.createNamedQuery("Application.findByJobpostingID", Application.class);
            q.setParameter("jobpostingID", id);
            ArrayList<Application> candidateIDs = new ArrayList(q.getResultList());
            return candidateIDs;
        } finally {
            em.close();
        }
    }

    /**
     * Retrieves an Application that matches both the job posting id and the
     * candidate id.
     *
     * @param jpID job posting id
     * @param canID candidate id
     * @return Application that matches the search query
     */
    public final Application getApplicationByBothID(int jpID, int canID) {
        initialize();
        try {
            TypedQuery<Application> q = em.createNamedQuery("Application.findByBothID", Application.class);
            q.setParameter("jobpostingID", jpID);
            q.setParameter("candidateID", canID);
            Application application = q.getSingleResult();
            return application;
        } finally {
            em.close();
        }
    }

    /**
     * Used to modify an existing BusinessClient profile.
     *
     * @param company company of the BusinessClient
     * @param username username of the BusinessClient
     * @param email email of the BusinessClient
     * @param phone phone of the BusinessClient
     * @param address address of the BusinessClient
     * @param website website of the BusinessClient
     * @param description description of the BusinessClient
     * @param bc BusinessClient
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> editBusinessClientProfile(String company, String username, String email, String phone, String address, String website, String description, BusinessClient bc) {
        initialize();
        ArrayList<String> errList = null;
        try {
            trans.begin();
            bc.setBusClientCompany(company);
            bc.setBusClientUsername(username);
            bc.setBusClientEmail(email);
            bc.setBusClientPhone(phone);
            bc.setBusClientAddress(address);
            bc.setBusClientWebsite(website);
            bc.setBusClientDescription(description);
            em.merge(bc);
            trans.commit();
        } catch (Exception ex) {
            errList.add("Unknown error occured. Please try again later");
        } finally {
            em.close();
            if (trans.isActive()) {
                trans.rollback();
            }
        }

        return errList;
    }

    /**
     * Updates the Business Client password.
     *
     * @param password new password
     * @param bc BusinessClient to update
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> setNewClientPassword(String password, BusinessClient bc) {
        initialize();
        ArrayList<String> errList = null;
        try {
            trans.begin();
            bc.setBusClientPassword(password);
            em.merge(bc);
            trans.commit();
        } catch (Exception ex) {
            errList.add("Unknown error occured. Please try again later");
        } finally {
            em.close();
            if (trans.isActive()) {
                trans.rollback();
            }
        }

        return errList;
    }

    /**
     * Used to modify and existing JobPosting.
     *
     * @param title title of the Job Posting
     * @param status status of the Job Posting
     * @param description description of the Job Posting
     * @param requirements requirements of the Job Posting
     * @param wage wage of the Job Posting
     * @param location location of the Job Posting
     * @param startDate start date of the Job Posting
     * @param endDate end date of the Job Posting
     * @param jp JobPosting
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> editJobPosting(String title, String status, String description, String requirements, Double wage, String location, Date startDate, Date endDate, JobPosting jp) {
        initialize();
        ArrayList<String> errList = null;
        try {
            trans.begin();
            jp.setJobTitle(title);
            jp.setJobStatus(status);
            jp.setJobDescription(description);
            jp.setRequirements(requirements);
            jp.setWage(wage);
            jp.setLocation(location);
            jp.setStartDate(startDate);
            jp.setEndDate(endDate);
            em.merge(jp);
            trans.commit();
        } catch (Exception ex) {
            errList.add("Unknown error occured. Please try again later");
        } finally {
            em.close();
            if (trans.isActive()) {
                trans.rollback();
            }
        }

        return errList;
    }

    /**
     * Add a new entry to the database.
     *
     * @param request request from the front-end
     * @param username username of the logged in user
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> add(HttpServletRequest request, String username) {
        initialize();
        try {
            trans.begin();
            // Gets appropriate feature depending upon form parameters
            Object feature = getNewFeature(request, username);
            // Checking to see if its null
            if (feature != null) {
                em.persist(feature);
            }
            trans.commit();
        } finally {
            em.close();
        }
        return null;
    }

    /**
     * Edit an existing entry in the database.
     *
     * @param request request from the front-end
     * @param username username of the logged in user
     * @return ArrayList of any errors that occurred
     */
    public final ArrayList<String> edit(HttpServletRequest request, String username) {
        initialize();

        try {
            trans.begin();
            // Gets appropriate feature depending upon form parameters
            Object feature = getNewFeature(request, username);
            // Checking to see if its null
            if (feature != null) {
                em.merge(feature);
            }
            trans.commit();
        } finally {
            em.close();
        }
        return null;
    }

    /**
     * Retrieves the appropriate feature to be modified.
     *
     * @param request request from the front-end
     * @param username username of the logged in user
     * @return Object for the specific feature
     */
    private Object getNewFeature(HttpServletRequest request, String username) {
        String form_name = request.getParameter("form_name");
        // Required for fetching required data 
        AccountServicesDB asdb = new AccountServicesDB();
        Candidate c = asdb.getCandidateByUsername(username);

        switch (form_name) {

            case "roles":
                String newRole = request.getParameter("candidateRole");
                String roleID = request.getParameter("id");
                CandidateRole role = (CandidateRole) request.getAttribute("canRole");
                role.setCandidateID(c);

                if (newRole == null || newRole.equals("")) {
                    role.setRoleID(asdb.getRoleById(roleID));
                } else {
                    role.setRoleID(asdb.getRoleById(newRole));
                }

                c.getCandidateRoleList().add(role);
                return role;

            case "skills":

                String newSkill = request.getParameter("candidateSkill");
                String skillID = request.getParameter("id");
                CandidateSkill skill = (CandidateSkill) request.getAttribute("canSkill");
                skill.setCandidateID(c);
                if (newSkill == null || newSkill.equals("")) {
                    skill.setSkillID(asdb.getSkillById(skillID));
                } else {
                    skill.setSkillID(asdb.getSkillById(newSkill));
                }

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

    /**
     * Deletes a profile feature ie. work history, skill etc.
     *
     * @param form_name form containing the information
     * @param id id to search by
     * @param username username of the logged in user
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> delete(String form_name, String id, String username) {
        initialize();
        ArrayList<String> errList = new ArrayList<>();

        try {
            int ID = Integer.parseInt(id);
            Object feature = em.find(getFeatureClass(form_name), ID);

            // ERROR HANDLING START
            if (feature == null) {
                errList.add("The item does not exist");
                return errList;
            }
            if (!belongsTo(form_name, em, ID, username)) {
                errList.add("The item you are trying to delete not yours");
                return errList;
            }

            //ERROR HANDLING END
            trans.begin();

            em.remove(feature);
            trans.commit();
        } catch (NumberFormatException e) {
            errList.add("Invalid data supplied. Please try again");
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }

        return errList;
    }

    /**
     * Used to delete a Candidate.
     *
     * @param username username to search by
     * @return boolean indicating if the operation was successful
     */
    public final boolean deleteCandidate(String username) {
        initialize();
        try {
            TypedQuery<Candidate> q = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class);
            q.setParameter("canUsername", username);
            Candidate c = q.getSingleResult();
            trans.begin();
            em.remove(c);
            trans.commit();
        } catch (Exception e) {
            return false;
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }

        return true;
    }

    /**
     * Deletes an application that matches the specified Application object.
     *
     * @param ap Application object to search by
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> deleteApplicationByID(Application ap) {
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try {
            trans.begin();
            Application app = em.merge(ap);
            em.remove(app);
            trans.commit();
        } catch (Exception e) {
            errList.add("Application could not be removed");
            return errList;
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }

        return null;
    }

    /**
     * Deletes a business client that matches the specified username.
     *
     * @param username username to search by
     * @return ArrayList containing any errors that occurred
     */
    public final ArrayList<String> deleteBusinessClient(String username) {
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try {
            TypedQuery<BusinessClient> q = em.createNamedQuery("BusinessClient.findByBusClientUsername", BusinessClient.class);
            q.setParameter("busClientUsername", username);
            BusinessClient businessClient = q.getSingleResult();
            trans.begin();
            BusinessClient bc = em.merge(businessClient);
            em.remove(bc);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            errList.add("Business Client could not be removed");
            return errList;
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
            em.close();
        }

        return null;
    }

    /**
     * This method checks whether the feature to be deleted is infact owned by
     * the user
     *
     * @param form_name Table to be updated
     * @return The class of the table
     */
    private final boolean belongsTo(String form_name, EntityManager em, int id, String username) {
        Serializable returnObj;
        boolean error = true;
        switch (form_name) {
            case "education":
                returnObj = em.find(Education.class, id);
                if (!((Education) returnObj).getCandidateID().getCanUsername().equals(username)) {
                    error = false;
                }
                break;

            case "workHistory":
                returnObj = em.find(WorkHistory.class, id);
                if (!((WorkHistory) returnObj).getCandidateID().getCanUsername().equals(username)) {
                    error = false;
                }
                break;
            case "skills":
                returnObj = em.find(CandidateSkill.class, id);
                if (!((CandidateSkill) returnObj).getCandidateID().getCanUsername().equals(username)) {
                    error = false;
                }
                break;
        }
        return error;
    }

    /**
     * Gets the appropriate feature class for the specified form name.
     *
     * @param form_name form name to get feature by
     * @return Class of the feature
     */
    private Class getFeatureClass(String form_name) {
        switch (form_name) {
            case "roles":
                return CandidateRole.class;
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
