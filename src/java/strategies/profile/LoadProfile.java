/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.profile;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface that is used as part of the Strategy Pattern for loading profile
 * content on our system.
 *
 * @author 839645
 * @version 1.0
 */
public interface LoadProfile {

    public void loadProfile(HttpServletRequest request);
}
