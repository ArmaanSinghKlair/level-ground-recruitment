/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
        String query = "SELECT a from "
    }
}
