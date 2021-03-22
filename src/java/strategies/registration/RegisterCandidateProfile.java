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
public class RegisterCandidateProfile implements RegisterProfile {

    @Override
    public ArrayList<String> register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password-repeat");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");

        ArrayList<String> errList = new AccountServices().createCandidateProfile(username, password, password_repeat, firstName, lastName, email, phoneNo);

        if (errList != null) {
            Candidate candidate = new Candidate();
            candidate.setCanUsername(username);
            candidate.setCanEmail(email);
            candidate.setCanfirstName(firstName);
            candidate.setCanlastName(lastName);
            candidate.setCanPhoneNo(phoneNo);
            request.setAttribute("lastCandidate", candidate);
            return errList;
        } else {
            return null;
        }
    }

}
