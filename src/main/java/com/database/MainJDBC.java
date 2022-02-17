package com.database;

import com.database.jdbc.query.CallableStatements;
import com.database.jdbc.db.JdbcConnection;
import com.database.jdbc.query.PreparedStatements;
import com.database.jdbc.query.Statements;

public class MainJDBC {

    public static void main(String[] args) {
        PreparedStatements preparedStatement = new PreparedStatements();
        CallableStatements callableStatement = new CallableStatements();
        Statements statements = new Statements(preparedStatement, callableStatement);
        JdbcConnection jdbcConnection = new JdbcConnection(statements);
        jdbcConnection.connect();
    }
}
