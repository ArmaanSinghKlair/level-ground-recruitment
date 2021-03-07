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
import javax.servlet.http.HttpSession;
import problemdomain.Advisor;
import services.AccountServices;

/**
 *
 * @author 756887
 */
@WebServlet(name = "AdvisorLoginServlet", urlPatterns = {"/AdvisorLoginServlet"})
public class AdvisorLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");    
    
        AccountServices service = new AccountServices();
        ArrayList<String> errList = service.authenticateAdvisor(username, password);
        
     
         if(errList == null){
            request.setAttribute("success",true);
            request.setAttribute("sucessMessage", "Logged In successfully");
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username);
        } else{
            Advisor advisor = new Advisor();
            advisor.setAdvisorUsername(username);
            request.setAttribute("lastAdvisor", advisor);
            request.setAttribute("fail",true);
            request.setAttribute("errList",errList);
        }
         
                request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);

    }
    
}
