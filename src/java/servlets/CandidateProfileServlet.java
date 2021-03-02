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
import services.AccountServices;
import services.ProfileServices;

/**
 *
 * @author 839645
 */
public class CandidateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/WEB-INF/candidate.jsp";
        AccountServices accService =new AccountServices();
        HttpSession sess = request.getSession(false);
        Candidate c = accService.getCandidateByUsername((String)sess.getAttribute("username"));
        request.setAttribute("candidate", c);
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Identifies which page request came from
        String action = request.getParameter("action");
        AccountServices accService =new AccountServices();
        HttpSession sess = request.getSession(false);
        ProfileServices ps = new ProfileServices();
        ArrayList<String> errList=new ArrayList<>();
        
        if(action != null && action.equals("profilePageAction")){
            errList = ps.profilePageAction(request.getParameter("submit"), request.getParameter("form_name"), request.getParameter("id"), (String)sess.getAttribute("username"));
        } else{
            errList.add("Unknown error occured. Please reload and try again");
        }
        
        if(errList == null || errList.isEmpty()){
            request.setAttribute("success",true);
            request.setAttribute("sucessMessage", getSuccessMessage(action));
        } else{
            request.setAttribute("fail",true);
            request.setAttribute("errList",errList);
        }
        
        //Load back updated User
        Candidate c = accService.getCandidateByUsername((String)sess.getAttribute("username"));
        request.setAttribute("candidate", c);
        request.getRequestDispatcher("/WEB-INF/candidate.jsp").forward(request, response);

    }

    /**
     * Gives the success message depending upon the page that sent the POST request
     * @param page Page that sent the request
     * @param request Request object used to get certain parameters
     * @return Success Message
     */
    private final String getSuccessMessage(String page){
        String str = "";
        switch(page){
            case "profilePageAction":
                str = "Item deleted successfully";
                break;  
        }
        return str;
    }
}
