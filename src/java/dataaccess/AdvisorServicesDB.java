/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import problemdomain.Advisor;
import util.DBUtil;

/**
 *
 * @author 839645
 */
public class AdvisorServicesDB {
    private EntityManager em;
    private EntityTransaction trans;
    
    public void initialize(){
        this.em = DBUtil.getEmFactory().createEntityManager();
        this.trans = this.em.getTransaction();
    }
    
    public synchronized Advisor getNextAdvisor(){
        this.initialize();
        try{
        String query = "SELECT jp.advisorID from JobPosting jp where jp.jobpostingID = (select max(j.jobpostingID) from JobPosting j);";
        TypedQuery<Advisor> q = em.createQuery(query, Advisor.class);
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            
        }
        return null;
    }
}
