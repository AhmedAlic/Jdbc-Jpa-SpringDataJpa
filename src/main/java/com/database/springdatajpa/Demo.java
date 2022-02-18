package com.database.springdatajpa;

import com.database.jpa.model.Employee;
import com.database.springdatajpa.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Demo implements CommandLineRunner {

    private final EmployeeServiceImpl employeeService;

    public Demo(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) {
        Employee employee = new Employee(100L, "Phillipe", "Chef");
        employeeService.saveOrUpdate(employee);
        Employee emp1 = employeeService.findById(employee.getId());
        log.info("Inserted employee: {}", emp1);
        employee.setOccupation("Master Chef");
        employeeService.update(employee);
        List<Employee> employeesList1 = employeeService.findAll();
        log.info("List of {} employees: {}", employeesList1.size(), employeesList1);
        employeeService.deleteById(employee.getId());
        log.info("List of {} employees after deletion: {}", employeeService.findAll().size(), employeeService);
    }
}
