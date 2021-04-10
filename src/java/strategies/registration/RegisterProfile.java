/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.registration;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 * Interface that is used as part of the Strategy Pattern
 * for registering new users on our system.
 *
 * @author kentp
 * @version 1.0
 */
public interface RegisterProfile {

    /**
     * Used to register a specific user on our system.
     * 
     * @param request Contains parameters for profile registration
     * @return String Arraylist containing any errors that may have occurred. 
     */
    public ArrayList<String> register(HttpServletRequest request);

}
