/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import strategies.search.SearchBehaviour;
import util.DBUtil;

/**
 *
 * @author 839645
 */
public class SearchServicesDB {
    private EntityManager em;
    private EntityTransaction trans;
    
    private void initialize(){
        em =DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }
    
    public String search(HttpServletRequest request, SearchBehaviour search){
        initialize();
        
        try{
           search.setEm(em);
            // return search results
            return search.search(request);
            
        }catch(NoResultException e){
            return "{\"error\":\"No such Job found\"}";
        }catch(Exception e){
           return e.getClass()+" "+Arrays.toString(e.getStackTrace());
            
        }finally{
            em.close();
            if(trans.isActive())
                trans.rollback();
        }
        
        // some serious error happens
        //return "";
        
    }
}
