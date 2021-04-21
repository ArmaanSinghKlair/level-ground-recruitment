/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * Utility used to encrypt passwords for the users on our system. Firstly, this
 * utility class hashes the passwords and then applies salt for added
 * encryption.
 *
 * @author 839645
 * @version 1.0
 */
public class PasswordUtil {

    /**
     * This code uses SHA-256. If this algorithm isn't available to you, you can
     * try a weaker level of encryption such as SHA-128.
     *
     * @param password password to be hashed
     * @return String containing hashed password
     * @throws NoSuchAlgorithmException thrown when the algorithm specified is
     * not available
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }

    /**
     * Returns the salt.
     *
     * @return String representing salt value
     */
    public static String getSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    /**
     * Used to hash a password and apply salt for added encryption.
     *
     * @param password password to be hashed
     * @return String containing hashed password
     * @throws NoSuchAlgorithmException thrown when the algorithm specified
     * doesn't exist
     */
    public static String hashAndSaltPassword(String password)
            throws NoSuchAlgorithmException {
        String salt = getSalt();
        return hashPassword(password + salt);
    }
}
