package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_simple?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";      // change if needed
    private static final String PASSWORD = "DUTTA@1034";  // change if needed

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // for MySQL 8.x
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
