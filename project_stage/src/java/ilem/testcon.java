/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilem;

import java.sql.*;

public class testcon {
    static Connection con=null;
    public static Connection getmyConnection() throws SQLException,ClassNotFoundException{
        if(con==null){
                 Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testxamp?zeroDateTimeBehavior=convertToNull","root","");
            
            
        }
        return con;
    }
    
}
