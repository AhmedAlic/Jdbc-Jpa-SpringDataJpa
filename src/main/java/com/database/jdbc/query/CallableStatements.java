package com.database.jdbc.query;

import com.database.jdbc.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CallableStatements {

    public void selectRecord(CallableStatement callableStatement) {
        List<Employee> employees = new ArrayList<>();
        try {
            callableStatement.setString(1, "Singer");
            log.info("Preparing to query with prepared statement: " + callableStatement);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setOccupation(resultSet.getString("occupation"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            log.info("List of employees with professor role:" + employees);
        }
    }

    public void insertRecord(CallableStatement callableStatement) {
        try {
            callableStatement.setInt(1, 1244);
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
