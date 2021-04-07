/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.registration;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Advisor;
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author kentp
 */
public class RegisterAdvisorProfile implements RegisterProfile {

    @Override
    public ArrayList<String> register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        System.out.println("****: " + username);
        
        ArrayList<String> errList = new AccountServices().createAdvisorProfile(username, password, firstName, lastName, email);
        request.setAttribute("url", "/WEB-INF/advisor-home.jsp");

        if (errList != null) {
            Advisor advisor = new Advisor();
            advisor.setAdvisorUsername(username);
            advisor.setAdvisorfirstName(firstName);
            advisor.setAdvisorlastName(lastName);
            advisor.setAdvisorEmail(email);
            request.setAttribute("lastAdvisor", advisor);
            return errList;
        } else {
            return null;
        }
    }

}
