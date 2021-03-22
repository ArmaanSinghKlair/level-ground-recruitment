/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.registration;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kentp
 */
public interface RegisterProfile {

    public ArrayList<String> register(HttpServletRequest request);

}
