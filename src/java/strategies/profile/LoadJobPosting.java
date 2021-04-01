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
import problemdomain.Application;
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
        
        int id = Integer.parseInt(request.getParameter("jobpostingID"));
        
        // Get job posting
        JobPosting jp = accService.getJobpostingByID(id);
        request.setAttribute("jobposting", jp);
        
        // Get applied candidates
        ArrayList<Application> apps = ps.getCandidateIDsByJobpostingID(jp.getJobpostingID());
        ArrayList<Candidate> candidates = null;
        for (Application app: apps)
        {
            candidates.add(app.getCandidateID());
        }
        request.setAttribute("candidates", candidates);
        request.setAttribute("url", "/WEB-INF/business-post-view.jsp"); //change this when correct page is added
    }
}
