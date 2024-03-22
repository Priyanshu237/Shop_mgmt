
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author priya
 */
public class dbms {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
         Class.forName("oracle.jdbc.driver.OracleDriver");
  String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; 
        String username = "shop"; 
        String password = "mgmt"; 
        Connection connection;
         
        // Establish a connection
        connection =  DriverManager.getConnection(jdbcUrl, username, password);

            // Create a statement
            Statement statement = connection.createStatement();
            ResultSet rs =statement.executeQuery("select* from adminLogin");
            System.out.println(rs.getString("id"));
                    
                    
        
    }
}
