/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kentp
 */
public class ProfileNavigationServlet extends HttpServlet {

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

        HttpSession session = request.getSession();
        String userType = session.getAttribute("userType").toString();

        System.out.println("test");

        if (userType != null && !userType.equals("")) {
            switch (userType) {
                case "candidate":
                    request.getRequestDispatcher("/candidate-profile").forward(request, response);
                    break;
                case "businessClient":
                    request.getRequestDispatcher("/business-client-profile").forward(request, response);
                    break;
                case "admin":
                    request.getRequestDispatcher("/admin-profile").forward(request, response);
                    break;
                default:
                    //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                    break;
            }
        }
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
        
        HttpSession session = request.getSession();
        String userType = session.getAttribute("userType").toString();

        System.out.println("test");

        if (userType != null && !userType.equals("")) {
            switch (userType) {
                case "candidate":
                    request.getRequestDispatcher("/candidate-profile").forward(request, response);
                    break;
                case "businessClient":
                    request.getRequestDispatcher("/business-client-profile").forward(request, response);
                    break;
                case "admin":
                    request.getRequestDispatcher("/admin-profile").forward(request, response);
                    break;
                default:
                    //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                    break;
            }
        }
    }
}
