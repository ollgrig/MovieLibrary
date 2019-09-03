package org.olga.repository.connection;

public class ConnectionConstant {
    static final String HOST = "localhost:3306";
    static final String DATABASE_NAME = "db";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    private ConnectionConstant() {
        throw new IllegalArgumentException("Should not be instantiated");
    }
}
