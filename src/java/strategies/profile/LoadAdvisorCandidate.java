/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.profile;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
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
public class LoadAdvisorCandidate implements LoadProfile {

    @Override
    public void loadProfile(HttpServletRequest request) {

        String jobID = request.getParameter("jobID");
        String clientID = request.getParameter("clientID");
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();

        // Get job posting
        JobPosting job = accService.getJobpostingByID(Integer.parseInt(jobID));

        // Get business client
        BusinessClient bc = ps.getBusinessClientByClientID(Integer.parseInt(clientID));

        // Get applied candidates
        ArrayList<Application> apps = ps.getApplicationsByJobpostingID(job);
        ArrayList<Candidate> candidates = new ArrayList<>();

        for (Application app : apps) {
            if (app.getStatus() == 1) {
                candidates.add(app.getCandidateID());
            }
        }

        request.setAttribute("job", job);
        request.setAttribute("company", bc);
        request.setAttribute("candidateList", candidates);

        request.setAttribute("url", "/WEB-INF/advisor-post-view.jsp");
    }
}
