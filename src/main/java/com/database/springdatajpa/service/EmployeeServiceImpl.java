package com.database.springdatajpa.service;

import com.database.jpa.model.Employee;
import com.database.springdatajpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
