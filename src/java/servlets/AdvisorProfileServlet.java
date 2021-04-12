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
 * Used alongside with the Advisor's home page.
 *
 * @author kentp
 * @version 1.0
 */
@WebServlet(name = "AdvisorProfileServlet", urlPatterns = {"/advisor-profile"})
public class AdvisorProfileServlet extends HttpServlet {

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

        String skill = request.getParameter("skill");
        String role = request.getParameter("role");
        AccountServices accServices = new AccountServices();
        ArrayList<String> errList;

        String successMessage = "";
        if (skill != null) {
            errList = accServices.createSkill(skill);
            successMessage = "Skill added successfully";
        } else if (role != null) {
            errList = accServices.createRole(role);
            successMessage = "Role added successfully";
        } else {
            errList = new ArrayList<>();
            errList.add("Unknown error occurred, please try again later.");
        }

        if (errList == null) {
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", successMessage);
        } else {
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
        }

        request.getRequestDispatcher("/profile-navigation").forward(request, response);
    }
}
