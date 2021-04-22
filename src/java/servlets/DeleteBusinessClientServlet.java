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
 * Deletes a business client and then returns them to the sign in page.
 * 
 * @author 756887
 */
@WebServlet(name = "DeleteBusinessClientServlet", urlPatterns = {"/delete-client"})
public class DeleteBusinessClientServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
    
        //Attempts to delete the business client account
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
