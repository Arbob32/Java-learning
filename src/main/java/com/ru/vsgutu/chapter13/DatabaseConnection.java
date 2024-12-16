package com.ru.vsgutu.chapter13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String connectionUrl;
    private final String username;
    private final String password;

    public DatabaseConnection(String connectionUrl, String username, String password) {
        this.connectionUrl = connectionUrl;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, username, password);
    }
}
