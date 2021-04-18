/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.profile;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import problemdomain.Candidate;
import problemdomain.Role;
import problemdomain.Skill;
import services.AccountServices;
import services.ProfileServices;

/**
 * Used to load the profile content for the Candidate. Implements LoadProfile
 * interface and adheres to the Strategy Pattern.
 *
 * @author 839645
 * @version 1.0
 */
public class LoadCandidateProfile implements LoadProfile {

    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();

        HttpSession sess = request.getSession(false);

        // Get candidate
        Candidate c = accService.getCandidateByUsername((String) sess.getAttribute("username"));
        request.setAttribute("candidate", c);

        // Get skills
        ArrayList<Skill> skills = ps.getAllSkills();
        request.setAttribute("skills", skills);

        //Get Roles
        ArrayList<Role> roles = ps.getAllRoles();
        request.setAttribute("roles", roles);

        request.setAttribute("url", "/WEB-INF/candidate.jsp");

    }
}
