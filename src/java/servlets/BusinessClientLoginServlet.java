/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountServices;

/**
 *
 * @author 756887
 */
@WebServlet(name = "BusinessClientLoginServlet", urlPatterns = {"/BusinessClientLoginServlet"})
public class BusinessClientLoginServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/BusinessClientLogin.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");    
    
        AccountServices service = new AccountServices();
        ArrayList<String> errList = service.authenticateBusinessClient(username, password);
        
        if (errList == null)    // If ERROR LIST NULL, then NO ERRORS
            {
                /*request.setAttribute("message", "Welcome, " + username);
                request.getRequestDispatcher("/WEB-INF/Homepage.jsp").forward(request, response);*/
                //USER LOGGED IN 
            } else
            {
                request.setAttribute("errList", errList);
                request.getRequestDispatcher("/WEB-INF/BusinessClientLogin.jsp").forward(request, response);
            }
    
    }

}
