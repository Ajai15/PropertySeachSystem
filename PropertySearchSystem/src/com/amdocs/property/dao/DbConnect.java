package com.amdocs.property.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    public static Connection getConnection() {
    	
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SYSTEM";
        String password = "Amdocs123";
        Connection connection=null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection == null) {
            	System.out.println("Failed to connect to Oracle SQL Developer!");
           
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to Oracle SQL Developer failed.");
            e.printStackTrace();
        }
        return connection;
        
    }
}

