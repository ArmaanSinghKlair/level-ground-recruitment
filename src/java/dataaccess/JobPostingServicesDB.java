/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import problemdomain.Application;
import problemdomain.Candidate;
import problemdomain.JobPosting;
import util.DBUtil;

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
}
