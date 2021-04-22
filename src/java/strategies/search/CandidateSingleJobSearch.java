/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.search;

import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import problemdomain.JobPosting;

/**
 * Used to search for a single job as the Candidate user type. Implements the
 * SearchBehaviour interface and adheres to the Strategy Pattern.
 *
 * @author 839645
 * @version 1.0
 */
public class CandidateSingleJobSearch implements SearchBehaviour {

    private EntityManager em;

    @Override
    public String search(HttpServletRequest request) throws Exception {
        String id = request.getParameter("jpi");

        // Error checking
        String error = this.validate(id);
        if (error != null) {
            return error;
        }

        // Getting the results
        JobPosting jp = em.find(JobPosting.class, Integer.parseInt(id));
        StringBuilder resultJson = new StringBuilder();

        jp.setApplicationList(null);
        jp.setBusinessclientID(null);
        jp.setAdvisorID(null);
        resultJson.append(new Gson().toJson(jp));
        return resultJson.toString();
    }

    /**
     * Validates the id String specified
     *
     * @param id id to validate
     * @return String containing validation results
     */
    private String validate(String id) {
        if (this.isEmpty(id) || !isInteger(id)) {
            return getError("Invalid information supplied");
        }

        return null;
    }

    /**
     * Returns the appropriate error message.
     *
     * @param str String to append into the error message
     * @return String containing error message
     */
    private String getError(String str) {
        return "{\"error:\"" + str + "\", \"querySuccessfull\":false}";
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }

}
