/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.search;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 839645
 */
public interface SearchBehaviour {
    public String search(HttpServletRequest request) throws Exception;
}
