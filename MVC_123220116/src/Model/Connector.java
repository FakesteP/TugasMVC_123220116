/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
/**
 *
 * @author Hafizh
 */
public class Connector {
    private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String db = "upnvy";
    private static String url = "jdbc:mysql://localhost:3306/" + db;
    private static String username = "root";
    private static String password = "";
    
    static Connection conn;
    
    public static Connection Connect() {
        try {
            Class.forName(jdbc_driver);           
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("MySQL Connected");
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Connection Failed: " + exception.getLocalizedMessage());
        }
        return conn;
    }
}
