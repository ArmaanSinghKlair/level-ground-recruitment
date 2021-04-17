/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import problemdomain.Application;
import problemdomain.Candidate;
import problemdomain.JobPosting;
import util.DBUtil;
import util.Gmail;

/**
 *
 * @author 839645
 */
public class JobPostingServicesDB {
    private EntityManager em;
    private EntityTransaction trans;
    
    private void initialize(){
        em =DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }
    
    public ArrayList<String> applyForJob(String username, String id){
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try{
        JobPosting jp = em.find(JobPosting.class, Integer.parseInt(id));
        Candidate c = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class).setParameter("canUsername", username).getSingleResult();
        
        for(Application a: jp.getApplicationList()){
            if(Objects.equals(a.getCandidateID().getCandidateID(), c.getCandidateID())){
                errList.add("You have already applied for this job");
                return errList;
            }
        }
        Application app = new Application();
        trans.begin();
            app.setCandidateID(c);
            app.setJobpostingID(jp);
            c.getApplicationList().add(app);
            jp.getApplicationList().add(app);
            jp.setApplicants(jp.getApplicants()+1);
            app.setStatus((short)0);
            em.persist(app);
        trans.commit();
        } finally{
            em.close();
            if(trans.isActive())
                trans.rollback();
        }
        
        return errList;
    }
    
    public ArrayList<String> rejectCandidateReview(int applicationID)
    {
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try{
            Application a = em.find(Application.class, applicationID);
            trans.begin();
            a.setStatus((short)-1);
            trans.commit();
        } finally{
            em.close();
            if(trans.isActive())
                trans.rollback();
        }
        
        return errList;
    }   
    
    public ArrayList<String> selectCandidateForReview(int applicationID){
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try{
            Application a = em.find(Application.class, applicationID);
            trans.begin();
            a.setStatus((short)1);
            trans.commit();
        } finally{
            em.close();
            if(trans.isActive())
                trans.rollback();
        }
        
        return errList;
    }
    
    public ArrayList<String> selectCandidateForInterview(int applicationID, String path){
        initialize();
        ArrayList<String> errList = new ArrayList<>();
        try{
            
            Application a = em.find(Application.class, applicationID);
            Candidate c = a.getCandidateID();
            trans.begin();
            a.setStatus((short)2);
            trans.commit();
            
            //Preparing the email
            HashMap<String,String> tags = new HashMap<>();
            tags.put("firstName", c.getCanfirstName());
            tags.put("lastName", c.getCanlastName());
            tags.put("jobTitle", a.getJobpostingID().getJobTitle());
            tags.put("companyName", a.getJobpostingID().getBusinessclientID().getBusClientCompany());
            tags.put("jobDescription", a.getJobpostingID().getJobDescription());
            Gmail.sendMail(c.getCanEmail(), "Interview Update for "+a.getJobpostingID().getJobTitle(), path+"/emailTemplates/interview.html", tags);
            
        } catch (Exception ex) {
            Logger.getLogger(JobPostingServicesDB.class.getName()).log(Level.SEVERE, null, ex);
            errList.add("Unknown error occured. Please try again later");
        } finally{
            em.close();
            if(trans.isActive())
                trans.rollback();
        }
        
        return errList;
    }
    
    public void decrementApplicants(int id)
    {
        initialize();
        try{
            JobPosting jp = em.find(JobPosting.class, id);
            trans.begin();
            jp.setApplicants(jp.getApplicants()-1);
            trans.commit();
        } finally{
            em.close();
            if(trans.isActive())
                trans.rollback();
        }
    } 

}
