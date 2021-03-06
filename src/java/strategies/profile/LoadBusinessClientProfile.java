/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.profile;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Application;
import problemdomain.BusinessClient;
import problemdomain.JobPosting;
import problemdomain.Candidate;
import services.AccountServices;
import services.ProfileServices;

/**
 * Used to load the profile content for the BusinessClient. Implements LoadProfile
 * interface and adheres to the Strategy Pattern.
 *
 * @author 756887
 * @version 1.0
 */
public class LoadBusinessClientProfile implements LoadProfile {

    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();

        HttpSession sess = request.getSession(false);

        // Get business client
        BusinessClient bc = accService.getBusinessClientByUsername((String) sess.getAttribute("username"));
        request.setAttribute("businessClient", bc);

        // Get job postings
        ArrayList<JobPosting> jobPostings = ps.getClientJobPostings(bc);
        request.setAttribute("jobPostings", jobPostings);
        request.setAttribute("url", "/WEB-INF/business-client-home.jsp");
    }
}
