/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import problemdomain.Advisor;
import util.DBUtil;

/**
 * Used for various advisor services.
 * 
 * @author 839645
 */
public class AdvisorServicesDB {
    private EntityManager em;
    private EntityTransaction trans;
    
    /**
     * Initialize the EntityManager and EntityTransaction for the various
     * methods within this class.
     */
    public void initialize(){
        this.em = DBUtil.getEmFactory().createEntityManager();
        this.trans = this.em.getTransaction();
    }
    
    /**
     * This method gets the next available advisor ID. This method is called 
     * whenever a new job posting is created.
     * 
     * @return Advisor ID
     */
    public synchronized int getNextAdvisorID(){
        this.initialize();
        try{
        String query = "SELECT j.advisorID from JobPosting j where j.jobpostingID = (select max(jp.jobpostingID) from JobPosting jp)";
        TypedQuery<Advisor> q = em.createQuery(query, Advisor.class);
        List<Advisor> lastAdvisor = q.getResultList();
        
        // If job postings available
        if(!(lastAdvisor == null || lastAdvisor.isEmpty())){
             Advisor nextAdvisor = em.find(Advisor.class, lastAdvisor.get(0).getAdvisorID()+1);
        
            // If next advisor available
            if(nextAdvisor!=null){
                    return nextAdvisor.getAdvisorID();
        }

        }
            return ((Advisor)em.createQuery("SELECT a from Advisor a ORDER BY a.advisorID", Advisor.class).setMaxResults(1).getResultList().get(0)).getAdvisorID();

        } catch(NoResultException e){
           // Advisor
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
            if(trans.isActive())
                trans.rollback();
        }
        return 0;
    }
}
