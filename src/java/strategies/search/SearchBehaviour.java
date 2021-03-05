/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.search;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 839645
 */
public interface SearchBehaviour {
    public String search(HttpServletRequest request) throws Exception;
    public default boolean isEmpty(String field){
        return field == null || field.trim().length() == 0;
    }
    public default boolean isInteger(String val){
        try{
            int i = Integer.parseInt(val);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public default boolean isDouble(String val){
        try{
            double i = Double.parseDouble(val);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public void setEm(EntityManager em);
}
