/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuna
 */
public class DBContext {
     public static String serverName = "localhost"; 
    public static String dbName = "vh_express";
    public static String portNumber = "3306";
    public static String userID = "root";
    public static String password = "12345"; 
//  String url = "jdbc:sqlserver://localhost:1433;databaseName=testSWP;encrypt=true;trustServerCertificate=true; user = sa; password = Tuna1.dev;";

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
            System.out.println(url);
            Class.forName("com.mysql.cj.jdbc.Driver"); // Sử dụng MySQL JDBC Driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=testSWP;encrypt=true;trustServerCertificate=true; user = sa; password = Tuna1.dev;";
            // Kết nối đến MySQL bằng tên người dùng và mật khẩu
            return DriverManager.getConnection(url, userID, password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    } 
    
//    Test connection
    public static void main(String[] args) {
        try{
            if(DBConnect.getConnection()!=null) System.out.println("Connect successfully!");
            else System.out.println("Connect failed!");
        } catch (Exception ex) {
            System.out.println(ex); 
            System.out.println("Error at model.DBContext.DBContext().getConnertion()");
        }        
    }
}
