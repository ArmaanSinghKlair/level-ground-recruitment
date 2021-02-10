/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 756887
 */
public class DBoperations {
    
    public String getCandidates()
    {
        String candidates = "";
        String sql = "select * from lgrdb.candidate;";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try
        {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next())
            {
                candidates = candidates + rs.getString(3) + "," + rs.getString(4) + ";";
            }
            
            rs.close();
            st.close();
            cp.freeConnection(conn);
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return candidates;
    }
}
