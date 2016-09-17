/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.FileManipulators;
/**
 *
 * @author Marek
 */
public class DbConnect {
    FileManipulators fm = new FileManipulators();
    String ip = fm.readIp();
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://"+ip+":3306/devlivec_storage";

    private static final String USER = "devlivec_marek";
    private static final String PASS = "marek123";

    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet result;
    
    public void connect(){
      try {
        Class.forName(JDBC_DRIVER);
        System.out.println("Opening connection...");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connection established");
      } 
      catch (ClassNotFoundException | SQLException e) {
      }
    }

    public void disconnect() {
      try {
        connection.close();
        System.out.println("Connection closed");
      } catch (SQLException e) {
      }
    }
    
}
