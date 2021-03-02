/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.ProfileServicesDB;
import java.util.ArrayList;


/**
 *
 * @author 839645
 */
public final class ProfileServices {
    private final ProfileServicesDB psdb= new ProfileServicesDB();

    public final ArrayList<String> profilePageAction(String submit, String form_name, String id, String username){
        ArrayList<String> errList = new ArrayList<>();
        if(isEmpty(submit) || isEmpty(id) || isEmpty(username)){
            errList.add("An error occured. Please reload and try again");
        }
        
        if(errList.size() > 0)
            return errList;
        
        switch(submit){
            case "delete":
              errList = psdb.delete(form_name, id, username);  
            break;
        }
        return errList;
        
        
        
    }
        
   
    private final boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
}
