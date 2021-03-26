/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.profile;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Advisor;
import problemdomain.BusinessClient;
import problemdomain.Candidate;
import problemdomain.JobPosting;
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author 756887
 */
public class LoadJobPosting implements LoadProfile{
    
    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();
        
        HttpSession sess = request.getSession(false);
        
        // Get job posting
        //JobPosting jp = accService.getJobPostingByUsername((String)sess.getAttribute("username"));
        //request.setAttribute("jobPosting", jp);
        
        // Get applied candidates
        //ArrayList<Candidate> candidates = ps.getCandidatesByJobpostingID(jp.getJobpostingID());
        //request.setAttribute("candidates", candidates);
        //request.setAttribute("url", "/WEB-INF/business-post-view.jsp");
    }
}
