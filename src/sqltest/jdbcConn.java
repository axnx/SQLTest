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

/**
 *
 * @author User
 */
public class jdbcConn {
   
    public static void main(String[] args) {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      }
      catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      System.out.println("JDBC Class found");
      int no_of_rows = 0;
      
      
       // Create a variable for the connection string.  
      //String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SL_MWUNDF;user=sa;password=sasql"; 
      String connectionUrl = "jdbc:sqlserver://localhost:1433;database=SL_MWUNDF;integratedSecurity=true"; 
      
      try {
         Connection con = DriverManager.getConnection(
                    connectionUrl);  
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Kunden");
         while (rs.next()) {
            no_of_rows++;
         }
         System.out.println("There are "+ no_of_rows + " record in the table");
      }
      catch(SQLException e){
         System.out.println("SQL exception occured" + e);
      }
   }
}