/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.DBUtil;

public class AccountServicesDB {
    public final HashMap<String,String> createCandidateProfile(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            // code waiting for problem domain classes and front end form data
            trans.commit();
        } finally{
            if(trans.isActive())
                trans.rollback();
            em.close();
        }
        return null;
    }
}
