/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import problemdomain.Candidate;
import services.AccountServices;

/**
 *
 * @author 839645
 */
public class CandidateCreateProfileServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("currentTab", "signup");
        this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password-repeat");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        ArrayList<String> errList = new AccountServices().createCandidateProfile(username, password, password_repeat,firstName, lastName, email, phoneNo);
        
        if(errList == null){
            
            request.setAttribute("success",true);
            request.setAttribute("sucessMessage", "Account created successfully");
        } else{
            Candidate candidate = new Candidate();
            candidate.setCanUsername(username);
            candidate.setCanEmail(email);
            candidate.setCanfirstName(firstName);
            candidate.setCanlastName(lastName);
            candidate.setCanPhoneNo(phoneNo);
            request.setAttribute("lastCandidate", candidate);
            request.setAttribute("fail",true);
            request.setAttribute("errList",errList);
        }
        
        request.setAttribute("currentTab", "signup");
        this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    
}
