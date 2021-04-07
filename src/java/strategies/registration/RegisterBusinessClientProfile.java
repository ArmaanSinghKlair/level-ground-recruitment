/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.registration;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import problemdomain.BusinessClient;
import services.AccountServices;

/**
 *
 * @author kentp
 */
public class RegisterBusinessClientProfile implements RegisterProfile {

    @Override
    public ArrayList<String> register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String company = request.getParameter("company");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password-repeat");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");

        ArrayList<String> errList = new AccountServices().createBusinessClientProfile(username, password, password_repeat, company, email, phoneNo);
        request.setAttribute("url", "/WEB-INF/signup.jsp");

        if (errList != null) {
            BusinessClient client = new BusinessClient();
            client.setBusClientCompany(company);
            client.setBusClientEmail(email);
            client.setBusClientPhone(phoneNo);
            request.setAttribute("lastClient", client);
            return errList;
        } else {
            return null;
        }

    }

}
