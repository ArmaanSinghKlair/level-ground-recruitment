/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import problemdomain.Candidate;
import util.DBUtil;

/**
 *
 * @author 756887
 */
public class DBoperations {
    
    public String getCandidates() {
        String result="";
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        Query candidates = em.createNamedQuery("Candidate.findAll", Candidate.class);
        
        try {
            List<Candidate> candidateList = candidates.getResultList();
            
            for (Candidate c: candidateList)
            {
                result = result + c.getCanUsername() + "," + c.getCanPassword() + ";";
            }
        } finally {
            em.close();
        }
        
        return result;
    }
} 
