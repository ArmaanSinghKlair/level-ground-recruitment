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
import problemdomain.Skill;
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author 839645
 */
public class LoadCandidateProfile implements LoadProfile{

    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService =new AccountServices();
        ProfileServices ps = new ProfileServices();
        
        HttpSession sess = request.getSession(false);
        
        // Get candidate
        Candidate c = accService.getCandidateByUsername((String)sess.getAttribute("username"));
        request.setAttribute("candidate", c);
        
        // Get skills
        ArrayList<Skill> skills = ps.getAllSkills();
        request.setAttribute("skills", skills);
        request.setAttribute("url", "/WEB-INF/candidate.jsp");

    }
    
}
