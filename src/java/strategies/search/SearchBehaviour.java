/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.search;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 * Interface that is used as part of the Strategy Pattern for searching for job
 * postings contained in our application.
 *
 * @author 839645
 * @version 1.0
 */
public interface SearchBehaviour {

    public String search(HttpServletRequest request) throws Exception;

    /**
     * Determines if the specified field is empty.
     *
     * @param field field to check
     * @return boolean indicating if field is empty.
     */
    public default boolean isEmpty(String field) {
        return field == null || field.trim().length() == 0;
    }

    /**
     * Determines if a String value is an integer.
     *
     * @param val value to check
     * @return boolean indicating if the String is an integer
     */
    public default boolean isInteger(String val) {
        try {
            int i = Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Determines if a String value is a double.
     *
     * @param val value to check
     * @return boolean indicating if the String is a double
     */
    public default boolean isDouble(String val) {
        try {
            double i = Double.parseDouble(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Sets the appropriate EntityManager object.
     *
     * @param em EntityManager to set
     */
    public void setEm(EntityManager em);
}
