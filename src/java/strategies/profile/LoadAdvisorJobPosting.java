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
 * Used to load the content for the Advisor business view. Implements
 * LoadProfile interface and adheres to the Strategy Pattern.
 *
 * @author kentp
 * @version 1.0
 */
public class LoadAdvisorJobPosting implements LoadProfile {

    @Override
    public void loadProfile(HttpServletRequest request) {

        //Get job postings from specific business client
        String clientID = request.getParameter("clientID");
        ProfileServices ps = new ProfileServices();
        HttpSession sess = request.getSession(false);

        Advisor a = new AccountServices().getAdvisorByUsername((String) sess.getAttribute("username"));
        BusinessClient bc = ps.getBusinessClientByClientID(Integer.parseInt(clientID));
        ArrayList<JobPosting> jobList = ps.getJobsForAdvisor(a.getAdvisorID(), bc.getBusinessclientID());

        request.setAttribute("company", bc);
        request.setAttribute("jobList", jobList);

        request.setAttribute("url", "/WEB-INF/advisor-business-view.jsp");
    }
}
