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
import problemdomain.BusinessClient;
import problemdomain.JobPosting;
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author kentp
 */
@WebServlet(name = "AdvisorJobPostingServlet", urlPatterns = {"/advisor-job"})
public class AdvisorJobPostingServlet extends HttpServlet {

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

        //Get job postings from specific business client
        String clientID = request.getParameter("clientID");
        ProfileServices ps = new ProfileServices();
        HttpSession sess = request.getSession(false);
        Advisor a = new AccountServices().getAdvisorByUsername((String)sess.getAttribute("username"));
        BusinessClient bc = ps.getBusinessClientByClientID(Integer.parseInt(clientID));
        ArrayList<JobPosting> jobList = ps.getJobsForAdvisor(a.getAdvisorID(),bc.getBusinessclientID());
        
        request.setAttribute("company", bc);
        request.setAttribute("jobList", jobList);

        request.getRequestDispatcher("/WEB-INF/advisor-business-view.jsp").forward(request, response);
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
            throws ServletException, IOException {
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
