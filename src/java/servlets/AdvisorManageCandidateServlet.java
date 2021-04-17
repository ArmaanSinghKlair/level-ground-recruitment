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
import problemdomain.Application;
import problemdomain.Candidate;
import problemdomain.JobPosting;
import services.AccountServices;
import services.JobPostingServices;
import services.ProfileServices;

/**
 * Used to either reject or approve a Candidate based on the button that was clicked.
 * Will delete the application from the database if the Candidate is rejected.
 * Otherwise the Application will get marked with a status of 1 if the Candidate is approved.
 * 
 * @author kentp
 * @version 1.0
 */
@WebServlet(name = "AdvisorManageCandidateServlet", urlPatterns = {"/advisor-candidate"})
public class AdvisorManageCandidateServlet extends HttpServlet {

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

        String action = request.getParameter("action");
        String jobID = request.getParameter("jobID");
        String candidateID = request.getParameter("canID");
        String successMessage = "";

        ProfileServices ps = new ProfileServices();
        AccountServices accServices = new AccountServices();

        JobPosting job = accServices.getJobpostingByID(Integer.parseInt(jobID));
        Candidate candidate = ps.getCandidateByID(Integer.parseInt(candidateID));
        Application app = ps.getApplicationForAdvisor(job.getJobpostingID(), candidate.getCandidateID());

        ArrayList<String> errList = null;
        if (action != null && !action.equals("")) {
            JobPostingServices jobServices = new JobPostingServices();
            request.setAttribute("applicationID", app.getApplicationID().toString());

            switch (action) {
                case "reject":
                    errList = ps.deleteApplicationByID(app);
                    successMessage = "Candidate Rejected";
                    break;

                case "accept":
                    errList = jobServices.selectCandidateForReview(request, response);
                    successMessage = "Candidate Approved";
                    break;
            }
        } else {
            if (errList == null) {
                errList = new ArrayList<>();
            }
            errList.add("Unexpected error, please try again later.");
        }

        if (errList == null || errList.isEmpty()) {
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", successMessage);
        } else {
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
        }

        request.getRequestDispatcher("/advisor-profile").forward(request, response);
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
