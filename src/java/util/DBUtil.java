
package util;

import javax.persistence.*;

/**
 * Utility used to connect to the database for our application.
 * @author
 * @version 1.0
 */
public class DBUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("level-ground-recruitmentPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
