/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountServices;

/**
 *
 * @author 839645
 */
public class CandidateCreateProfileServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/test-create-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        ArrayList<String> errList = new AccountServices().createCandidateProfile(username, password, firstName, lastName, email, phoneNo);
        
        if(errList == null){
            request.setAttribute("finalMsg", "All good");
        } else{
            request.setAttribute("errList",errList);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/test-create-profile.jsp").forward(request, response);
    }

    
}
