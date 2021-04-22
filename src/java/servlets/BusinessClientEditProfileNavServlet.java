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
import problemdomain.BusinessClient;
import problemdomain.JobPosting;
import services.AccountServices;
import services.ProfileServices;

/**
 * Navigates the business client to their edit profile page.
 * 
 * @author 756887
 */
@WebServlet(name = "BusinessClientEditProfileNavServlet", urlPatterns = {"/edit-client-profile-nav"})
public class BusinessClientEditProfileNavServlet extends HttpServlet {

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
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();

        HttpSession sess = request.getSession(false);
        
        // Get business client
        BusinessClient bc = accService.getBusinessClientByUsername((String) sess.getAttribute("username"));
        request.setAttribute("businessClient", bc);
        
        // Get job postings
        ArrayList<JobPosting> jobPostings = ps.getClientJobPostings(bc);
        request.setAttribute("jobPostings", jobPostings);
        request.getRequestDispatcher("/WEB-INF/business-profile-edit.jsp").forward(request, response);
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
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();

        HttpSession sess = request.getSession(false);
        
        // Get business client
        BusinessClient bc = accService.getBusinessClientByUsername((String) sess.getAttribute("username"));
        request.setAttribute("businessClient", bc);
        
        // Get job postings
        ArrayList<JobPosting> jobPostings = ps.getClientJobPostings(bc);
        request.setAttribute("jobPostings", jobPostings);
        request.getRequestDispatcher("/WEB-INF/business-profile-edit.jsp").forward(request, response);
    }

}
