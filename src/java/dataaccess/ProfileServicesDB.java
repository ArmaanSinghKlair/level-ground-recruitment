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
 *
 * @author 839645
 */
public final class ProfileServicesDB {

    private EntityManager em;
    private EntityTransaction trans;

    private void initialize() {
        em = DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }

    public final ArrayList<Skill> getAllSkills() {
        initialize();
        try {
            ArrayList<Skill> skills = new ArrayList(em.createNamedQuery("Skill.findAll", Skill.class).getResultList());
            return skills;
        } finally {
            em.close();
        }
    }

    public final ArrayList<Role> getAllRoles() {
        initialize();
        try {
            ArrayList<Role> roles = new ArrayList(em.createNamedQuery("Role.findAll", Role.class).getResultList());
            return roles;
        } finally {
            em.close();
        }
    }

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

    private Object getNewFeature(HttpServletRequest request, String username) {
        String form_name = request.getParameter("form_name");
        // Required for fetching required data 
        AccountServicesDB asdb = new AccountServicesDB();
        Candidate c = asdb.getCandidateByUsername(username);

        switch (form_name) {

            case "roles":
                String roleID = request.getParameter("id");
                CandidateRole role = new CandidateRole();

                role.setCandidateID(c);

                Role actualRole = asdb.getRoleById(roleID);
                role.setRoleID(actualRole);

                c.getCandidateRoleList().add(role);
                return role;

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
