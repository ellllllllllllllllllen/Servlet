package edu.epam.servlet.config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static final String URL = "jdbc:mysql://localhost:3306/javaee";
    public static final String USER = "root";
    public static final String PASSWORD = "4521";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
