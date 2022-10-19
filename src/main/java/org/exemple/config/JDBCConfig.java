package org.exemple.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {
    public final Connection connection;

    public JDBCConfig() throws SQLException {
        connection= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JDBCTEST",
                "postgres",
                "1234"

        );
    }

    public Connection getConnection() {
        return connection;
    }
}
