/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import problemdomain.BusinessClient;
import problemdomain.JobPosting;

/**
 *
 * @author kentp
 */
@WebServlet(name = "BusinessClientTestServlet", urlPatterns = {"/BusinessClientTestServlet"})
public class BusinessClientTestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<JobPosting> jobList = new ArrayList<>();
        JobPosting jobPosting = new JobPosting();
        jobPosting.setJobpostingID(1);
        jobPosting.setRequirements("Java");
        jobPosting.setStartDate(new Date());
        jobPosting.setEndDate(new Date());
        
        JobPosting jobPosting2 = new JobPosting();
        jobPosting2.setJobpostingID(2);
        jobPosting2.setRequirements("C++");
        jobPosting2.setStartDate(new Date());
        jobPosting2.setEndDate(new Date());
        
        jobList.add(jobPosting);
        jobList.add(jobPosting2);
        
        request.setAttribute("jobList", jobList);
        request.getRequestDispatcher("/WEB-INF/businessClientPage.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            throws ServletException, IOException 
    {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
