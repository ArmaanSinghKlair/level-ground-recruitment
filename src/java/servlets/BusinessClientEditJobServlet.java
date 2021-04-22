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
 * Used to allow the business client to edit their job postings. Redirects
 * the client to their home page after editing their job posting.
 * 
 * @author 756887
 */
@WebServlet(name = "BusinessClientEditJobServlet", urlPatterns = {"/edit-job-posting"})
public class BusinessClientEditJobServlet extends HttpServlet {
    
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
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();
        
        String id = request.getParameter("postingID"); //JobPosting ID
        String title = request.getParameter("title");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String requirements = request.getParameter("requirements");
        String wage = request.getParameter("wage");
        String location = request.getParameter("location");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        
        // Get business client
        JobPosting jp = accService.getJobpostingByID(Integer.parseInt(id));
        
        
        ArrayList<String> errList = ps.editJobPosting(title, status, description, requirements, wage, location, startDate, endDate, jp);
        if (errList != null)
        {
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
        } else
        {
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", "Profile edited successfully");
        }
        request.getRequestDispatcher("/edit-client-profile-nav").forward(request, response);
    }
}
