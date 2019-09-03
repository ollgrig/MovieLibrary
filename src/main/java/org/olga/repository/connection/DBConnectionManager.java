package org.olga.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private final String url;

    public DBConnectionManager() {
        this.url = "jdbc:mysql://" + ConnectionConstant.HOST + "/" + ConnectionConstant.DATABASE_NAME;

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, ConnectionConstant.USERNAME, ConnectionConstant.PASSWORD);
    }
}
