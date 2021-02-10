/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author 756887
 */
public class ConnectionPool {
    
    private static ConnectionPool pool=null;
    private static DataSource dataSource=null;
    
    private ConnectionPool()
    {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/lgrdb");
        }
        catch (NamingException ex){
            ex.printStackTrace();
        }
    }
    
    public static synchronized ConnectionPool getInstance() {
        if (pool == null)
        {
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    public Connection getConnection()
    {
        try {
            return dataSource.getConnection();
        } catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void freeConnection(Connection conn)
    {
        try {
            conn.close();
        } catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
}
