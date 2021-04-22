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
 * Deletes a job posting then returns the user to the business client home page.
 * 
 * @author 756887
 */
@WebServlet(name = "DeleteJobPosting", urlPatterns = {"/delete-job-posting"})
public class DeleteJobPostingServlet extends HttpServlet {
    
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
        String url = "/profile-navigation";
       
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("postingID")); //JobPosting ID
    
        // Attempts to delete job posting
        AccountServices service = new AccountServices();
        ArrayList<String> errList = service.deleteJobPostingByID(id);
        
        if (errList == null)
            {
                request.setAttribute("success", true);
                request.setAttribute("sucessMessage", "Job posting deleted");
                request.getRequestDispatcher("/profile-navigation").forward(request, response);
            } else
            {
                request.setAttribute("fail", true);
                request.setAttribute("errList", errList);
                request.getRequestDispatcher("/profile-navigation").forward(request, response);
            }
    
    }
}
