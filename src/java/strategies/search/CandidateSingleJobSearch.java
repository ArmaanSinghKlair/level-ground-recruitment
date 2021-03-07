/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.search;

import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import problemdomain.JobPosting;

/**
 *
 * @author 839645
 */
public class CandidateSingleJobSearch implements SearchBehaviour{
    private EntityManager em;

    @Override
    public String search(HttpServletRequest request) throws Exception {
        String id = request.getParameter("jpi");
        
        // Error checking
        String error = this.validate(id);
        if(error != null){
            return error;
        }
        
        // Getting the results
        JobPosting jp = em.find(JobPosting.class, Integer.parseInt(id));
        StringBuilder resultJson = new StringBuilder();

        jp.setApplicationList(null);
        jp.setBusinessclientID(null);
        resultJson.append(new Gson().toJson(jp));
        return resultJson.toString();
    }
    
    private String validate(String id){
       if(this.isEmpty(id) || !isInteger(id))
            return getError("Invalid information supplied");
     
        
        return null;
    }
    
    private String getError(String str){
        return "{\"error:\""+str+"\", \"querySuccessfull\":false}";
    }
   
    @Override
    public void setEm(EntityManager em){
        this.em = em;
    }
    
    
    
    
    
      
   
    
   
    
}
