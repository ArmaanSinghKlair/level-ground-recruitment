/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.JobPostingServicesDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 839645
 */
public class JobPostingServices {
    private JobPostingServicesDB jpsd = new JobPostingServicesDB();
    
    public void applyForJob(HttpServletRequest request, HttpServletResponse response){
        String username = (String) request.getSession().getAttribute("username");
        ArrayList<String> errList = new ArrayList<String>();
        String id = request.getParameter("jpi");    // Job Posting ID
        
        if(isEmpty(username) || isEmpty(id))
            errList.add("All fields required");
            
        errList.addAll(jpsd.applyForJob(username, id));
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        if(!errList.isEmpty()){
            sb.append("\"querySuccessfull\":false,");
            sb.append("\"errors\":");
            sb.append(getArrayString(errList));
        }else{
            sb.append("\"querySuccessfull\":true");
        }
        sb.append("}");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw;
        try {
            pw = response.getWriter();
            pw.print(sb.toString());
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(JobPostingServices.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    private final boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
    
    private String getArrayString(ArrayList<String> arr){
        StringBuilder sb = new StringBuilder("[");
        arr.forEach(str -> {
            sb.append("\"").append(str).append("\"").append(",");
        });
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
    
    
}
