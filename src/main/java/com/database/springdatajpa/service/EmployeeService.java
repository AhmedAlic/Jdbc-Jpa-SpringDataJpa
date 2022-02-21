package com.database.springdatajpa.service;

import com.database.jpa.model.Employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {

    CompletableFuture<List<Employee>> findAll();
    Employee findById(Long id);
    void saveOrUpdate(Employee employee);
    void update(Employee employee);
    void deleteById(Long id);
    void deleteAll();
}
