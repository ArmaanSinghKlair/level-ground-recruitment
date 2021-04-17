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
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author 756887
 */
@WebServlet(name = "DeleteBusinessClientServlet", urlPatterns = {"/delete-client"})
public class DeleteBusinessClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
    
        ProfileServices ps = new ProfileServices();
        ArrayList<String> errList = ps.deleteBusinessClient(username);
        
        if (errList == null)
        {
            session.invalidate();
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", "Account deleted");
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
        } else
        {
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
            request.getRequestDispatcher("/profile-navigation").forward(request, response);
        }
    }
}
