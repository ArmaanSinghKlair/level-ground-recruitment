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
public class LoadBusinessClientProfile implements LoadProfile{

    @Override
    public void loadProfile(HttpServletRequest request) {
        AccountServices accService =new AccountServices();
        ProfileServices ps = new ProfileServices();
        
        HttpSession sess = request.getSession(false);
        
        // Get BusinessClient
        //BusinessClient bc = accService.getBusinessClientByUsername((String)sess.getAttribute("username"));
        //request.setAttribute("businessClient", bc);
        request.setAttribute("url", "/WEB-INF/businessClientHome.jsp");
    }
    
}
