package com.database.jdbc.db;

import com.database.jdbc.query.Statements;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class JdbcConnection {
    private final String url = "jdbc:postgresql://localhost:5432/postgres?escapeSyntaxCallMode=call";
    private final String user = "postgres";
    private final String password = "postgres123";
    private final Statements statements;

    public JdbcConnection(Statements statements) {
        this.statements = statements;
    }

    public void connect() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            log.info("Connected to the PostgreSQL server with user " + user + " on port ");
            statements.executeStatements(connection);
        } catch (SQLException e) {
            log.info("Connection failed");
            e.printStackTrace();
        }
    }
}
