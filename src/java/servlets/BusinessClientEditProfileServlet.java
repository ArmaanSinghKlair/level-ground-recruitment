/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import problemdomain.BusinessClient;
import services.AccountServices;
import services.ProfileServices;
import util.PasswordUtil;
import validation.ValidateBusinessClient;

/**
 *
 * @author 756887
 */
@WebServlet(name = "BusinessClientEditProfileServlet", urlPatterns = {"/edit-client-profile"})
public class BusinessClientEditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountServices accService = new AccountServices();
        ProfileServices ps = new ProfileServices();

        HttpSession sess = request.getSession(false);
        
        String company = request.getParameter("businessName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String website = request.getParameter("website");
        String description = request.getParameter("about");
        
        String curPass = request.getParameter("cur-pass");
        String newPass = request.getParameter("new-pass");
        String confPass = request.getParameter("conf-pass");
        
        // Get business client
        BusinessClient bc = accService.getBusinessClientByUsername((String) sess.getAttribute("username"));
        
        try {
            if (ValidateBusinessClient.validateBusClientPassword(newPass) == null && newPass.equals(confPass) && PasswordUtil.hashPassword(curPass).equals(bc.getBusClientPassword()))
            {
                ps.setNewClientPassword(PasswordUtil.hashPassword(newPass), bc);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BusinessClientEditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<String> errList = null;
        ArrayList<String> valErrList = ValidateBusinessClient.validateEdit(company, username, email, phone, address, website, description);
        if (valErrList == null)
        {
            errList = ps.editBusinessClientProfile(company, username, email, phone, address, website, description, bc);
            if (valErrList != null || errList != null)
            {
                request.setAttribute("fail", true);
                request.setAttribute("errList", errList);
            } else
            {
                sess.setAttribute("username", username);
                request.setAttribute("success", true);
                request.setAttribute("sucessMessage", "Profile edited successfully");
            }
        } else
        {
            request.setAttribute("fail", true);
            request.setAttribute("errList", valErrList);
        }
        
        
        request.getRequestDispatcher("/edit-client-profile-nav").forward(request, response);
    }
}
