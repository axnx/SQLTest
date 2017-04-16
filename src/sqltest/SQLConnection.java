/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SQLConnection {
    
    private static String url;// = "jdbc:mysql://localhost:3306/prototypeeop";    
    private static String driverName;// = "com.mysql.jdbc.Driver";   
    private static String username;// = "root";   
    private static String password;// = "triala";
    
    private static String urlstring;
    private static Connection con;
    
    SQLConnection (String urlstring, String driverName,String username, String password){
        SQLConnection.url = urlstring;
        SQLConnection.driverName = driverName;
        SQLConnection.username = username;
        SQLConnection.password = password;
    }
    
    SQLConnection (String urlstring, String driverName){
        SQLConnection.url = urlstring;
        SQLConnection.driverName = driverName;
    }   
    
    public boolean connect(){
        con = getConnection();
        return true;
    }
  
    public boolean disconnect(){
        try {
            if(con!=null){
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
  
    public ResultSet getResultset(String sql){
        Statement stmt;
        ResultSet rs = null;
        try {
            if(con==null){
                con = getConnection();
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }   
    
    
    public String getFirstLine(String sql){
        Statement stmt;
        ResultSet rs = null;
        String rv = null;
        try {
            if(con==null){
                con = getConnection();
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            rv = rs.getString(1);           
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rv;
    }   
    
    
    public int getFirstLineInt(String sql){
        Statement stmt;
        ResultSet rs = null;
        int rv = 0;
        try {
            if(con==null){
                con = getConnection();
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            rv = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rv;
    }   
    
    public Connection getConnection() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url);   //(urlstring, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        
        return con;
        
    }
}
