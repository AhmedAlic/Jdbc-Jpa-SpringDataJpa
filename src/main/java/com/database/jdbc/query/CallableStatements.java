package com.database.jdbc.query;

import lombok.extern.slf4j.Slf4j;

import java.sql.CallableStatement;
import java.sql.SQLException;

@Slf4j
public class CallableStatements {

    public void insertRecord(CallableStatement callableStatement) {
        try {
            callableStatement.setInt(1, 1246);
            callableStatement.setString(2, "John");
            callableStatement.setString(3, "Programmer");
            callableStatement.execute();
            log.info("Insert was successful");
        } catch (SQLException e) {
            log.info("Insert was unsuccessful");
            e.printStackTrace();
        }
    }
}
