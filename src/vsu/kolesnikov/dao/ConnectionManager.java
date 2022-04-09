package vsu.kolesnikov.dao;

import java.sql.*;

public class ConnectionManager {
    private final static String URL = "jdbc:postgresql://localhost:5432/traindb";
    private final static String USER = "postgres";
    private final static String PASS = "1234";

    private static ConnectionManager connectionManager;

    private ConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
