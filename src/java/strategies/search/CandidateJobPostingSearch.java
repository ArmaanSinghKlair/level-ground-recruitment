/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.search;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import problemdomain.JobPosting;

/**
 *
 * @author 839645
 */
public class CandidateJobPostingSearch implements SearchBehaviour{
    private EntityManager em;
    public CandidateJobPostingSearch(EntityManager em){
        this.em = em;
    }

    @Override
    public String search(HttpServletRequest request) throws Exception {
        String minSalary = request.getParameter("minSalary");
        String location = request.getParameter("location");
        String title = request.getParameter("title");
        String status = request.getParameter("status");
        String paginate = request.getParameter("pn");
        String pageLength = request.getParameter("pl");
        
        //TypedQuery q = em.createQuery("SELECT j from JobPosting where j.", JobPosting.class);
    }
    
   
    
}
