/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import problemdomain.Candidate;
import services.AccountServices;
import services.JobPostingServices;

/**
 *
 * @author 756887
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("applicationID", "2");
        //System.out.println(new JobPostingServices().selectCandidateForInterview(request, response));
        System.out.println(new JobPostingServices().selectCandidateForReview(request, response));
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        AccountServices service = new AccountServices();
        ArrayList<String> errList = service.authenticate(username, password, userType);

        if (errList == null) {
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", "Logged In successfully");
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username);
            session.setAttribute("userType", userType);
        } else {
            Candidate candidate = new Candidate();
            candidate.setCanUsername(username);
            request.setAttribute("lastCandidate", candidate);
            
            //Depending on which user tried to login, their radiobutton will be selected based on lastUserType
            request.setAttribute("lastUserType", userType);
            
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
            
            //Redirect user to login page if error in login
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
            return;
        }

        //Redirect user to their profile page if they login successfully
        request.getRequestDispatcher("/profile-navigation").forward(request, response);
    }

}
