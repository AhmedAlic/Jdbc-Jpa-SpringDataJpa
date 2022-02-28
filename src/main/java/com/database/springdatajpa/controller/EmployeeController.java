package com.database.springdatajpa.controller;

import com.database.model.Employee;
import com.database.springdatajpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public CompletableFuture<List<Employee>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Employee> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public void insert(@RequestBody Employee employee) {
        service.insert(employee);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Employee employee, @PathVariable Long id) {
        service.update(employee, id);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
