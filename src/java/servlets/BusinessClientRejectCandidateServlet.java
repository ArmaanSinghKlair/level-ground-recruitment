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
import services.JobPostingServices;
import services.ProfileServices;

/**
 *
 * @author 756887
 */
@WebServlet(name = "BusinessClientRejectCandidateServlet", urlPatterns = {"/reject-candidate"})
public class BusinessClientRejectCandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProfileServices ps = new ProfileServices();
        JobPostingServices jps = new JobPostingServices();
        
        int canID = Integer.parseInt(request.getParameter("candidateID"));
        int postID = Integer.parseInt(request.getParameter("postingID"));
        
        // Get application
        Application app = ps.getApplicationByBothID(postID, canID);
        ArrayList<String> errList = ps.deleteApplicationByID(app);
        if (errList != null)
        {
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
        } else
        {
            jps.decrementApplicants(postID);
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", "Client rejected");
        }
        
        request.getRequestDispatcher("/business-client-job-posting").forward(request, response);
    }
}
