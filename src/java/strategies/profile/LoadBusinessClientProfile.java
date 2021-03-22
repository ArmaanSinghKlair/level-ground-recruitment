/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.profile;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.BusinessClient;
import problemdomain.JobPosting;
import problemdomain.Candidate;
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author 756887
 */
public class LoadBusinessClientProfile implements LoadProfile {
    
    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();
        
        HttpSession sess = request.getSession(false);
        
        // Get business client
        BusinessClient bc = accService.getBusinessClientByUsername((String)sess.getAttribute("username"));
        request.setAttribute("businessClient", bc);
        
        // Get job postings
        ArrayList<JobPosting> jobPostings = ps.getClientJobPostings(bc.getBusinessclientID());
        request.setAttribute("jobPostings", jobPostings);
    }
}
