package com.database.springdatajpa.service;

import com.database.jpa.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    void insert(Employee employee);
    void update(Employee employee);
    void deleteById(Long id) ;
    void deleteAll();
}
