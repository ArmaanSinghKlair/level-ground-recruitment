/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.authentication;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import problemdomain.Advisor;
import util.PasswordUtil;

/**
 * This class Authenticates an advisors login information
 * 
 * @author 839645
 */
public class AdvisorAuthentication implements Authentication{
    
    private final EntityManager em;
    public AdvisorAuthentication(EntityManager em){
        this.em = em;
    }

    @Override
    public ArrayList<String> authenticate(String username, String password) throws NoResultException, NoSuchAlgorithmException {
        TypedQuery<Advisor> query = em.createNamedQuery("Advisor.findByAdvisorUsername", Advisor.class).setParameter("advisorUsername", username.toLowerCase());
        Advisor admin = query.getSingleResult();
        ArrayList<String> errList = new ArrayList<>();
        
        String hashedInputPassword = PasswordUtil.hashPassword(password);
        if(hashedInputPassword.equals(admin.getAdvisorPassword())){
            return null;
        } else{
            errList.add("Invalid Username or password");
        }
        return errList;
    }
    
   
    
}
