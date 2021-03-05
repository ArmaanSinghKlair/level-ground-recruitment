/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.authentication;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import problemdomain.Candidate;
import util.PasswordUtil;

/**
 *
 * @author 839645
 */
public class CandidateAuthentication implements Authentication{
    
    private final EntityManager em;
    public CandidateAuthentication(EntityManager em){
        this.em = em;
    }

    @Override
    public ArrayList<String> authenticate(String username, String password) throws NoResultException, NoSuchAlgorithmException {
        TypedQuery<Candidate> query = em.createNamedQuery("Candidate.findByCanUsername", Candidate.class).setParameter("canUsername", username.toLowerCase());
        Candidate candidate = query.getSingleResult();
        ArrayList<String> errList = new ArrayList<>();
        
        String hashedInputPassword = PasswordUtil.hashPassword(password);
        if(hashedInputPassword.equals(candidate.getCanPassword())){
            return null;
        } else{
            errList.add("Invalid Username or password");
        }
        return errList;
    }
    
   
    
}
