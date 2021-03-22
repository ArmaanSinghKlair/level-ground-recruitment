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
import problemdomain.JobPosting;
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author 756887
 */
public class LoadAdvisorProfile implements LoadProfile{
    
    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();
        
        HttpSession sess = request.getSession(false);
        
        // Get advisor
        Advisor a = accService.getAdvisorByUsername((String)sess.getAttribute("username"));
        request.setAttribute("advisor", a);
        
        // Get business clients
        ArrayList<BusinessClient> businessClients = ps.getBusClientsByAdvisorID(a.getAdvisorID());
        request.setAttribute("businessClients", businessClients);
        request.setAttribute("url", "/WEB-INF/advisor.jsp");
    }
}
