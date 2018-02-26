package com.courses.spalah.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDb {
    private Connection connection;

    public ConnectionDb() throws SQLException, ClassNotFoundException, IOException {
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream(".\\module16\\src\\main\\resources\\config.properties");
        properties.load(input);
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");

        connection = DriverManager.getConnection(url, login, password);
    }

    public Connection getConnection() {
        return connection;
    }
}
