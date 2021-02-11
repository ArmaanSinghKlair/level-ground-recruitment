/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.AccountServicesDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import services.AccountServices;

/**
 *
 * @author 756887
 */
@WebServlet(name = "CandidateLoginServlet", urlPatterns = {"/candidate-login"})
public class CandidateLoginServlet extends HttpServlet {

    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String username = request.getParameter("username");
        String password = request.getParameter("password");    
    
        
        
        
        if (username == null || password == null)
        {
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        } else if (username.equals("") || password.equals(""))
        {
            request.setAttribute("message", "Both username and password are required!");
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        } else
        {
            boolean found = false;
            AccountServicesDB dbops = new AccountServicesDB();
            String[] candidates = dbops.getCandidates().split(";");
            for (String candidate : candidates)
            {
                if (!candidate.equals(""))
                {
                    String canUsername = candidate.substring(0, candidate.indexOf(","));
                    String canPassword = candidate.substring(candidate.lastIndexOf(",")+1);
                    if (canUsername.equals(username) && canPassword.equals(password))
                    {
                        found = true;
                    }
                }

            }
            if (found)
            {
                request.setAttribute("message", "Welcome, " + username);
                request.getRequestDispatcher("/WEB-INF/Homepage.jsp").forward(request, response);
            } else
            {
                request.setAttribute("message", "Incorrect login information!");
                request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
            }
            
        }
    }
*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");    
    
        AccountServices service = new AccountServices();
        ArrayList<String> errList = service.authenticateCandidate(username, password);
        
        if (errList == null)    // If ERROR LIST NULL, then NO ERRORS
            {
                /*request.setAttribute("message", "Welcome, " + username);
                request.getRequestDispatcher("/WEB-INF/Homepage.jsp").forward(request, response);*/
                //USER LOGGED IN 
            } else
            {
                request.setAttribute("errList", errList);
                request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
            }
    
    }

}
