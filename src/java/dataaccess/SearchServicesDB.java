/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import strategies.search.SearchBehaviour;
import util.DBUtil;

/**
 * Search services for direct access with our database.
 *
 * @author 839645
 * @version 1.0
 */
public class SearchServicesDB {

    private EntityManager em;
    private EntityTransaction trans;

    /**
     * Used to initialize the EntityManager.
     */
    private void initialize() {
        em = DBUtil.getEmFactory().createEntityManager();
        trans = em.getTransaction();
    }

    /**
     * Used to search for job postings as the Candidate user.
     *
     * @param request request from the front-end
     * @param search SearchBehaviour object to search with
     * @return String containing results
     */
    public String search(HttpServletRequest request, SearchBehaviour search) {
        initialize();

        try {
            search.setEm(em);
            // return search results
            return search.search(request);

        } catch (NoResultException e) {
            return "{\"error\":\"No such Job found\"}";
        } catch (Exception e) {
            return e.getClass() + " " + Arrays.toString(e.getStackTrace());

        } finally {
            em.close();
            if (trans.isActive()) {
                trans.rollback();
            }
        }

        // some serious error happens
        //return "";
    }
}
