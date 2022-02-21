package com.database.springdatajpa;

import com.database.jpa.model.Employee;
import com.database.springdatajpa.service.EmployeeServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class Demo implements CommandLineRunner {

    private final EmployeeServiceImpl employeeService;

    public Demo(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @SneakyThrows
    @Override
    public void run(String... args) {
        Employee employee1 = new Employee(100L, "Phillipe", "Chef");
        Employee employee2 = new Employee(200L, "Maria", "Singer");
        Employee employee3 = new Employee(300L, "John", "Programmer");
        employeeService.saveOrUpdate(employee1);
        employeeService.saveOrUpdate(employee2);
        employeeService.saveOrUpdate(employee3);
        Employee emp1 = employeeService.findById(employee1.getId());
        log.info("Inserted employee1: {}", emp1);
        employee1.setOccupation("Master Chef");
        employeeService.update(employee1);
        CompletableFuture<List<Employee>> employeesList1 = employeeService.findAll();
        log.info("List of {} employees: {}", employeesList1.get().size(), employeesList1);
        employeeService.deleteById(employee1.getId());
        log.info("List of {} employees after deletion: {}", employeeService.findAll().get().size(), employeeService.findAll());
        employeeService.deleteAll();
        log.info("List of {} employees after deletion: {}", employeeService.findAll().get().size(), employeeService.findAll());
    }
}
