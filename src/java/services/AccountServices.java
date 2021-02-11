/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.AccountServicesDB;
import java.util.ArrayList;
import java.util.HashMap;
import validation.ValidateCandidate;

/**
 *
 * @author 839645
 */
public class AccountServices {
    private final AccountServicesDB asdb= new AccountServicesDB();
    
    public final ArrayList<String> createCandidateProfile(String username,String password,String firstName,String lastName, String email, String phoneNo){
        ArrayList<String> errList;
        errList = ValidateCandidate.getErrorMapForAllfields(username, password, firstName, lastName, email, phoneNo, null, null, null, null, null, null);
        
        if(errList != null)
            return errList;
        else
            return asdb.createCandidateProfile(username, password, firstName, lastName, email, phoneNo);
    }
    
    public final ArrayList<String> authenticateCandidate(String username, String password) {
        ArrayList<String> errList = new ArrayList<>();
        add(errList,ValidateCandidate.validateCanUsername(username));       //Validate username and get errors IF ANY
        add(errList,ValidateCandidate.validateCanPassword(password));       //Validate username and get errors IF ANY
        
        if(errList.isEmpty()){
            return asdb.authenticateCandidate(username, password);
        } else{
            return errList;
        }
    }
    
    private final boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
    
    private final void add(ArrayList<String> errList, String value){
        if(value != null)
            errList.add(value);
    }
}
