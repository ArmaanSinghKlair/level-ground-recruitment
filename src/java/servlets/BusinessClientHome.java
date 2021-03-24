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
@WebServlet(name = "BusinessClientHome", urlPatterns = {"/BusinessClientHome"})
public class BusinessClientHome extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/business-client-home.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String requirements = request.getParameter("requirements");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String wage = request.getParameter("wage");
        String location = request.getParameter("location");
    
        AccountServices service = new AccountServices();
        ArrayList<String> errList = service.createJobPosting(title, requirements, startDate, endDate, status, description, wage, location);
        
        if (errList == null)
            {
                request.setAttribute("message", "Job posting created");
                request.getRequestDispatcher("/WEB-INF/business-client-home.jsp").forward(request, response);
            } else
            {
                request.setAttribute("errList", errList);
                request.getRequestDispatcher("/WEB-INF/business-client-home.jsp").forward(request, response);
            }
    
    }

}
