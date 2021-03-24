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
import problemdomain.BusinessClient;
import util.PasswordUtil;

/**
 * This class authenticates a business clients login information
 * 
 * @author 839645
 */
public class BusinessClientAuthentication implements Authentication{
    
    private final EntityManager em;
    public BusinessClientAuthentication(EntityManager em){
        this.em = em;
    }

    @Override
    public ArrayList<String> authenticate(String username, String password) throws NoResultException, NoSuchAlgorithmException {
        TypedQuery<BusinessClient> query = em.createNamedQuery("BusinessClient.findByBusClientUsername", BusinessClient.class).setParameter("busClientUsername", username.toLowerCase());
        BusinessClient candidate = query.getSingleResult();
        ArrayList<String> errList = new ArrayList<>();
        
        String hashedInputPassword = PasswordUtil.hashPassword(password);
        if(hashedInputPassword.equals(candidate.getBusClientPassword())){
            return null;
        } else{
            errList.add("Invalid Username or password");
        }
        return errList;
    }
    
   
    
}
