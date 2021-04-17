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
import problemdomain.CandidateSkill;
import problemdomain.JobPosting;
import problemdomain.Skill;
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author 756887
 */
public class LoadClientJobPosting implements LoadProfile{
    
    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();
        
        int id = Integer.parseInt(request.getParameter("postingID"));
        
        // Get job posting
        JobPosting jp = accService.getJobpostingByID(id);
        request.setAttribute("jobposting", jp);
        
        // Get applied candidates
        ArrayList<Application> apps = ps.getApplicationsByJobpostingID(jp);
        ArrayList<Candidate> candidates = new ArrayList<>();
        for (Application app: apps)
        {
            if (app.getStatus() == 1)
            {
                candidates.add(app.getCandidateID());
            }
        }
        request.setAttribute("candidates", candidates);
        request.setAttribute("url", "/WEB-INF/business-post-view.jsp");
    }
}
