/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author CompuWorld
 */
public class DBConnection {

    public boolean check = false;
    public Connection conn;
   
    public Connection ConnectDB() {
        //jdbc 
        try {
            
             Class.forName("com.mysql.jdbc.Driver");      
//            //create connection
            conn= DriverManager.getConnection("jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8120627?useUnicode=yes&characterEncoding=UTF-8", "sql8120627", "pPUVsMuFy3");
//            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sql8120627?user=root", "root", "password");
//            jdbc:mysql://localhost:3306/?user=root
            check = true;
            
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database.");
            check = false;
        }
        return null;
    }

    public void CloseConnection() {
        try {
            conn.close();
            check = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
