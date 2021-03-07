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
 *
 * @author 839645
 */
public class SearchServices {
    public String search(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        SearchServicesDB ss = new SearchServicesDB();
        switch(userType){
            case "candidate":
                if(request.getParameter("jpi") != null)
                    return ss.search(request, new CandidateSingleJobSearch());
                return ss.search(request, new CandidateAllJobsSearch());
            default:
                return "Not Authorized to view data";
        }
    }
}
