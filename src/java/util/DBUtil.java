package util;

import javax.persistence.*;

/**
 * Utility used for database connections within our application.
 *
 * @author 839645
 * @version 1.0
 */
public class DBUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("level-ground-recruitmentPU(Local)");

    /**
     * Accessor method.
     *
     * @return EntityManagerFactory object
     */
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
