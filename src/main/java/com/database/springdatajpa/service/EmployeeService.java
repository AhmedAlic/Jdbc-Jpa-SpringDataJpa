package com.database.springdatajpa.service;

import com.database.jpa.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(Long id);
    void insert(Employee employee);
    void update(Employee employee);
    void deleteById(Long id) ;
    void deleteAll();
}
