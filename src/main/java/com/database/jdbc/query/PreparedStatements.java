package com.database.jdbc.query;

import com.database.jdbc.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PreparedStatements {

    public void selectRecord(PreparedStatement preparedStatement) {
        List<Employee> employees = new ArrayList<>();
        try {
            preparedStatement.setString(1, "Professor");
            log.info("Preparing to query with prepared statement: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
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

    public void insertRecord(PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1, 1244);
            preparedStatement.setString(2, "Josh");
            preparedStatement.setString(3, "Singer");
            log.info("Preparing to query with prepared statement: " + preparedStatement);
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet == 1) {
                log.info("Insert was successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, "Raj");
            preparedStatement.setString(2, "Actor");
            preparedStatement.setInt(3, 1240);
            log.info("Preparing to query with prepared statement: " + preparedStatement);
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet == 1) {
                log.info("Update was successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1, 1243);
            log.info("Preparing to query with prepared statement: " + preparedStatement);
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet == 1) {
                log.info("Delete was successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
