/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.search;

import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 839645
 */
public class CandidateAllJobsSearch implements SearchBehaviour{
    private EntityManager em;

    @Override
    public String search(HttpServletRequest request) throws Exception {
        String minSalary = request.getParameter("sal");
        String location = request.getParameter("loc");
        String title = request.getParameter("ti");
        String status = request.getParameter("stat");
        String paginate = request.getParameter("pn");
        String pageLength = request.getParameter("pl");
        
        String error = this.validate(minSalary, paginate, pageLength);
        
        
        if(error != null){
            return error;
        }
        
        //Preparing the statement
        StringBuilder query = new StringBuilder("SELECT j.jobpostingID, j.jobTitle, j.jobStatus, j.postDate, j.endDate FROM JobPosting j where ");
        if(!this.isEmpty(minSalary))
            query.append("j.wage > :minSalary and ");
        if(!this.isEmpty(location))
            query.append("j.location like :location and ");
        if(!this.isEmpty(title))
            query.append("FUNCTION('levenshtein',j.jobTitle, :title) <= 8 and ");
        if(!this.isEmpty(status))
            query.append("j.jobStatus = :status ");
        
        if(query.substring(query.length()-4).equals("and ")){
            query.delete(query.length()-4, query.length()-1);
        }
        
        
        // Setting the parameters
        Query q = em.createQuery(query.toString());
        // Add a .00 after whole number because field is a double
        if(minSalary != null && minSalary.indexOf('.')==-1){
            minSalary += ".00";
        }
         if(!this.isEmpty(minSalary))
            q.setParameter("minSalary", Double.parseDouble(minSalary));
        if(!this.isEmpty(location))
            q.setParameter("location", "%"+location+"%");
        if(!this.isEmpty(title))
            q.setParameter("title", title);
        if(!this.isEmpty(status))
            q.setParameter("status", status);
        

        q.setFirstResult((Integer.parseInt(paginate)-1)*Integer.parseInt(pageLength));
        q.setMaxResults(Integer.parseInt(pageLength)+1);
        int MAX = Integer.parseInt(pageLength);

        // Getting the results
        List<Object[]> results = q.getResultList();
        
        int resultCount = results == null ? 0 : results.size();
        StringBuilder resultJson = new StringBuilder("{\"rowCount\":"+(resultCount==MAX+1?resultCount-1:resultCount)+"}");

        // If results Found
        if(resultCount > 0){
            
            resultJson.setCharAt(resultJson.length()-1, ',');
            resultJson.append("\"data\": [");
       
           // return String.valueOf(val[0]);
           int i=0;
           System.out.println("MAX= "+MAX+" plength = "+pageLength+" pno= "+paginate);
            for(Object[] o: results){
                resultJson.append("{").append(this.getJsonField("jobpostingID",String.valueOf(o[0]),true)).append(",");
                resultJson.append(this.getJsonField("jobTitle",String.valueOf(o[1]).trim(),false)).append(",");
                resultJson.append(this.getJsonField("jobStatus",String.valueOf(o[2]).trim(),false)).append(",");
                resultJson.append(this.getJsonField("postDate",String.valueOf(o[3]).trim(),false)).append(",");
                resultJson.append(this.getJsonField("endDate",String.valueOf(o[4]).trim(),false)).append("},");
                i++;
                
                if(i==MAX)
                    break;
                else{
                    System.out.println(MAX+" = max, i = "+i); 
                }
            }
            // Remove that extra comma in the end
            resultJson.deleteCharAt(resultJson.length()-1);
            resultJson.append("]");
            if(resultCount == MAX+1)
                resultJson.append(", \"hasMore\":true}");
            else
                resultJson.append(", \"hasMore\":false}");
            
        }
        return resultJson.toString();
    }
    
    private String validate(String minSalary, String paginate, String paginateLength){
        if(!isEmpty(minSalary) && !(this.isDouble(minSalary) ||this.isInteger(minSalary)))
            return getError("Salary is not a valid number");
        if(this.isEmpty(paginate) || this.isEmpty(paginateLength))
            return getError("Pagination paramters are required");
        if(!this.isInteger(paginate) || !this.isInteger(paginateLength))
            return getError("Pagination parameters are not numbers");
        if(minSalary != null && (minSalary.indexOf('.') > -1 ? Double.parseDouble(minSalary):Integer.parseInt(minSalary))< 0)
            return getError("Salary cannot be negative");
        return null;
    }
    
    private String getError(String str){
        return "{\"error:\""+str+"\", \"querySuccessfull\":false}";
    }
   
    private String getJsonField(String name, String value, boolean number){
        return number ? "\""+name+"\":"+value+"" :"\""+name+"\":\""+value+"\"";
    }
    @Override
    public void setEm(EntityManager em){
        this.em = em;
    }
    
    
    
    
    
      
   
    
   
    
}
