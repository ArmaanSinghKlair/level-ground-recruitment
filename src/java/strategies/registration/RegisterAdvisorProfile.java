/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.registration;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Candidate;
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
        String email = request.getParameter("email");

        
        ArrayList<String> errList = null;// new AccountServices().createAdvisorProfile(username, password, password_repeat, firstName, lastName, email, phoneNo);

        if (errList != null) {
            
            return errList;
        } else {
            return null;
        }
    }

}
