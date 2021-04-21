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
 * Used with the Business Client pages and performs different actions such as
 * creating a new job posting and redirecting the user to the appropriate
 * webpage.
 *
 * @author 756887
 * @version 1.0
 */
@WebServlet(name = "BusinessClientProfileServlet", urlPatterns = {"/business-client-profile"})
public class BusinessClientProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/profile-navigation";

        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String requirements = request.getParameter("requirement");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String wage = request.getParameter("wage");
        String location = request.getParameter("location");
        String username = request.getParameter("username");

        AccountServices service = new AccountServices();
        ArrayList<String> errList = service.createJobPosting(title, requirements, startDate, endDate, status, description, wage, location, username);

        if (errList == null) {
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", "Job posting created");
            request.getRequestDispatcher("/profile-navigation").forward(request, response);
        } else {
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
            request.getRequestDispatcher("/profile-navigation").forward(request, response);
        }

    }
}
