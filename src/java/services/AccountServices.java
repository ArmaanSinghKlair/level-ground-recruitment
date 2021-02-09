/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.AccountServicesDB;
import java.util.HashMap;
import validation.ValidateCandidate;

/**
 *
 * @author 839645
 */
public class AccountServices {
    private final AccountServicesDB asdb= new AccountServicesDB();
    
    public final HashMap<String,String> createCandidateProfile(String username,String password,String firstName,String lastName, String email, String phoneNo){
        HashMap<String,String> errMap;
        errMap = ValidateCandidate.validateBasicCandidate(username, password, firstName, lastName, email, phoneNo);
        
        if(errMap != null)
            return errMap;
        else
            return asdb.createCandidateProfile(username, password, firstName, lastName, email, phoneNo);
        

    }
    
    private final boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
}
