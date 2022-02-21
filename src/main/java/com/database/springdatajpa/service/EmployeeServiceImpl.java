package com.database.springdatajpa.service;

import com.database.jpa.model.Employee;
import com.database.springdatajpa.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    @Async
    public CompletableFuture<List<Employee>> findAll() {
        List<Employee> list = employeeRepository.findAll();
        return CompletableFuture.completedFuture(list);
    }

    @Override
    @Transactional
    @Async
    public CompletableFuture<Employee> findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return CompletableFuture.completedFuture(employee.orElse(null));
    }

    @Override
    @Transactional
    @Async
    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    @Async
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    @Async
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    @Async
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
