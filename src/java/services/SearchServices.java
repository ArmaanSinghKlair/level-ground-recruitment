/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.SearchServicesDB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import strategies.search.*;

/**
 * Contains various methods to perform search related services and actions for
 * the Candidate. Adheres to the Strategy pattern.
 *
 * @author 839645
 * @version 1.0
 */
public class SearchServices {

    /**
     * Used to search for job postings as the Candidate user.
     *
     * @param request request from the front-end
     * @return String containing results of the search
     */
    public String search(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        SearchServicesDB ss = new SearchServicesDB();
        switch (userType) {
            case "candidate":
                if (request.getParameter("jpi") != null) {
                    return ss.search(request, new CandidateSingleJobSearch());
                }
                return ss.search(request, new CandidateAllJobsSearch());
            default:
                return "Not Authorized to view data";
        }
    }
}
