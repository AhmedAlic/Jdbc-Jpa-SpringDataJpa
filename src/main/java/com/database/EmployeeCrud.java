package com.database;

import com.database.model.Employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface EmployeeCrud {

    CompletableFuture<List<Employee>> findAll();

    CompletableFuture<Employee> findById(Long id);

    CompletableFuture<Employee> insert(Employee employee);

    CompletableFuture<Employee> update(Employee employee, Long id);

    void deleteById(Long id);

    void deleteAll();
}
