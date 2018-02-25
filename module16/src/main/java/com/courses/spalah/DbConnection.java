package com.courses.spalah;

import java.sql.*;

class DbConnection {
    private Connection connection;

    public DbConnection() throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3306";
        final String USER_NAME = "admin";
        final String USER_PASSWORD = "admin";

        connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }
}
