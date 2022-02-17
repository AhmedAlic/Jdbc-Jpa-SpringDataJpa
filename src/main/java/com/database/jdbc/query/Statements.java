package com.database.jdbc.query;

import lombok.extern.slf4j.Slf4j;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.Connection.TRANSACTION_SERIALIZABLE;

@Slf4j
public class Statements {

    private static final String SELECT_FROM_OCCUPATIONS = "SELECT * FROM occupations WHERE occupation=?";
    private static final String INSERT_INTO_OCCUPATIONS = "INSERT INTO occupations (id, name, occupation) VALUES (?, ?, ?)";
    private static final String UPDATE_INTO_OCCUPATIONS = "UPDATE occupations SET name = ?, occupation = ? WHERE id = ?";
    private static final String DELETE_FROM_OCCUPATIONS = "DELETE FROM occupations WHERE id = ?";
    private static final String SELECT_FROM_OCCUPATIONS_QUERY = "{call selectEmployee(?)}";
    private static final String INSERT_INTO_OCCUPATIONS_QUERY = "{call insertEmployee(?, ?, ?)}";
    private final PreparedStatements preparedStatement;
    private final CallableStatements callableStatements;

    public Statements(PreparedStatements preparedStatement, CallableStatements callableStatements) {
        this.preparedStatement = preparedStatement;
        this.callableStatements = callableStatements;
    }

    public void executeStatements(Connection connection) throws SQLException {
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(TRANSACTION_SERIALIZABLE);
            PreparedStatement selectPStatement = connection.prepareStatement(SELECT_FROM_OCCUPATIONS);
            PreparedStatement insertPStatement = connection.prepareStatement(INSERT_INTO_OCCUPATIONS);
            PreparedStatement updatePStatement = connection.prepareStatement(UPDATE_INTO_OCCUPATIONS);
            PreparedStatement deletePStatement = connection.prepareStatement(DELETE_FROM_OCCUPATIONS);

            CallableStatement selectCStatement = connection.prepareCall(SELECT_FROM_OCCUPATIONS_QUERY);
            CallableStatement insertCStatement = connection.prepareCall(INSERT_INTO_OCCUPATIONS_QUERY);

            preparedStatement.selectRecord(selectPStatement);
            preparedStatement.insertRecord(insertPStatement);
            preparedStatement.updateRecord(updatePStatement);
            preparedStatement.deleteRecord(deletePStatement);

//            Not working, don't know if postgres driver can call stored procedure using callable statement ?
//            callableStatements.selectRecord(selectCStatement);
            callableStatements.insertRecord(insertCStatement);

            connection.commit();
        } catch (SQLException e) {
            log.warn("Unsuccessful querying!");
            e.printStackTrace();
            connection.rollback();
        }
    }
}
