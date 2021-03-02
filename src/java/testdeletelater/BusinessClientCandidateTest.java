/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdeletelater;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import problemdomain.Candidate;
import problemdomain.CandidateSkill;
import problemdomain.Education;
import problemdomain.Role;
import problemdomain.Skill;
import problemdomain.WorkHistory;

/**
 *
 * @author kentp
 */
@WebServlet(name = "BusinessClientCandidateTest", urlPatterns = {"/BusinessClientCandidateTest"})
public class BusinessClientCandidateTest extends HttpServlet {

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
        Candidate candidate = new Candidate();
        candidate.setCandidateID(1);

        ArrayList<Education> educationList = new ArrayList<>();
        ArrayList<WorkHistory> workList = new ArrayList<>();
        ArrayList<CandidateSkill> skillList = new ArrayList<>();
        ArrayList<Role> roleList = new ArrayList<>();

        Education education = new Education();
        education.setInstitution("SAIT");
        education.setSubject("ITSD");
        education.setLevel("Advanced");
        education.setStartDate(new Date());
        education.setEndDate(new Date());
        educationList.add(education);

        WorkHistory workHistory = new WorkHistory();
        workHistory.setCompany("Walmart");
        workHistory.setStartDate(new Date());
        workHistory.setEndDate(new Date());
        workList.add(workHistory);

        CandidateSkill candidateSkill = new CandidateSkill();
        Skill skill = new Skill();
        skill.setDescription("Java");
        candidateSkill.setSkillID(skill);
        skillList.add(candidateSkill);

        Role role = new Role();
        role.setDescription("Web Developer");
        roleList.add(role);

        candidate.setWorkHistoryList(workList);
        candidate.setEducationList(educationList);
        candidate.setCandidateSkillList(skillList);
        candidate.setRoleList(roleList);

        ArrayList<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate);

        request.setAttribute("candidateList", candidateList);
        request.getRequestDispatcher("/WEB-INF/businessClientCandidateList.jsp").forward(request, response);

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
