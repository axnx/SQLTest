/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltest;

import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class SQLTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        private static String url = "jdbc:mysql://localhost:3306/prototypeeop";    
//        private static String driverName = "com.mysql.jdbc.Driver";   
//        private static String username = "root";   
//        private static String password = "triala";

        String urlstring, driverName, username, password;
        urlstring = "jdbc:sqlserver://localhost:1433;database=SL_MWUNDF;integratedSecurity=true";;
        driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        username = "sa";
        password = "sasql";
        //SQLConnection c = new SQLConnection(urlstring, driverName, username, password);
        SQLConnection c = new SQLConnection(urlstring, driverName);
        //c.connect();
        
        //ResultSet rs = c.executeSQL("SELECT COUNT(*) FROM [SL_MWUNDF].[dbo].[Kunden]");
        
        //String r = c.getFirstLine("SELECT COUNT(*) FROM [SL_MWUNDF].[dbo].[Kunden]");
        String r = c.getFirstLine("SELECT [BelegSperre] FROM [SL_MWUNDF].[dbo].[Kunden] WHERE KUNDEN_ID=3");
        c.disconnect();
        System.out.println(r);
        
        
        
    }
    
}
