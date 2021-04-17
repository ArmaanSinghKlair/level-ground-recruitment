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
 *
 * @author 756887
 */
@WebServlet(name = "DeleteJobPosting", urlPatterns = {"/delete-job-posting"})
public class DeleteJobPostingServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/profile-navigation";
       
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("postingID"));
    
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
