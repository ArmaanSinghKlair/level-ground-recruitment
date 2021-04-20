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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import problemdomain.Candidate;
import problemdomain.Role;
import problemdomain.Skill;
import services.AccountServices;
import services.ProfileServices;

/**
 * @author AmirS
 */
public class CandidateProfileEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();

        HttpSession sess = request.getSession(false);

        // Get candidate
        Candidate c = accService.getCandidateByUsername((String) sess.getAttribute("username"));
        request.setAttribute("candidate", c);

        // Get skills
        ArrayList<Skill> skills = ps.getAllSkills();
        request.setAttribute("skills", skills);

//        // Get roles
        ArrayList<Role> roles = ps.getAllRoles();
        request.setAttribute("roles", roles);
        request.getRequestDispatcher("/WEB-INF/candidate-profile-edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
