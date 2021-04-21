package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.JobPostingServices;

/**
 * Used to redirect the Candidate to the job posting page as well as apply for
 * job postings.
 *
 * @author AmirS
 * @version 1.0
 */
public class CandidateJobPostingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action != null) {
            switch (action) {
                case "apply":
                    new JobPostingServices().applyForJob(request, response);
                    break;
            }
            return;
        } else {
            request.getRequestDispatcher("/WEB-INF/candidate-job-posting.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
