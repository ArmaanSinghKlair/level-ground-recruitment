/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.authentication;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.persistence.NoResultException;

/**
 *
 * @author 839645
 */
public interface Authentication {
    public ArrayList<String> authenticate(String username, String password) throws NoResultException, NoSuchAlgorithmException;
}
