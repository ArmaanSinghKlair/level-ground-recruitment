/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
 * Used with the Candidate pages and performs different actions such as adding
 * new content to the Candidate profile or changing existing content.
 *
 * @author 839645
 * @version 1.0
 */
public class CandidateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/profile-navigation";
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Identifies which page request came from
        String action = request.getParameter("action");
        AccountServices accService = new AccountServices();
        HttpSession sess = request.getSession(false);
        ProfileServices ps = new ProfileServices();
        ArrayList<String> errList = new ArrayList<>();

        if (action != null && action.equals("profilePageAction")) {
            errList = ps.profilePageAction(request, (String) sess.getAttribute("username"));
        } else {
            errList.add("Unknown error occured. Please reload and try again");
        }

        // Generate success message depending upon the type of request OR give a list of errors
        if (errList == null || errList.isEmpty()) {
            request.setAttribute("success", true);
            request.setAttribute("sucessMessage", getSuccessMessage(request.getParameter("submit")));
        } else {
            request.setAttribute("fail", true);
            request.setAttribute("errList", errList);
        }
        String submit = request.getParameter("submit");

        // If user deleted 
        if (submit != null && submit.equals("deleteCandidate")) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
            return;
        }
        //Load back updated User
        // Get candidate
        Candidate c = accService.getCandidateByUsername((String) sess.getAttribute("username"));
        request.setAttribute("candidate", c);

        // Get skills
        ArrayList<Skill> skills = ps.getAllSkills();
        request.setAttribute("skills", skills);

        // Get roles
        ArrayList<Role> roles = ps.getAllRoles();
        request.setAttribute("roles", roles);

        request.setAttribute("candidate", c);
        String url = "/WEB-INF/candidate.jsp";

        if (submit != null && submit.equals("edit")) {
            url = "/WEB-INF/candidate-profile-edit.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Gives the success message depending upon the page that sent the POST
     * request
     *
     * @param page Page that sent the request
     * @param request Request object used to get certain parameters
     * @return Success Message
     */
    private final String getSuccessMessage(String submit) {
        String str = "";
        switch (submit) {
            case "delete":
                str = "Item(s) deleted successfully";
                break;
            case "add":
                str = "Item(s) added successfully";
                break;
            case "edit":
                str = "Item(s) edited successfully";
                break;
            case "deleteCandidate":
                str = "Account deleted successfully";
                break;
        }
        return str;
    }
}
