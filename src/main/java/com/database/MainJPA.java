package com.database;

import com.database.jpa.config.Hibernate;
import com.database.jpa.config.Jpa;
import com.database.model.Employee;
import com.database.jpa.service.EmployeeHibernate;
import com.database.jpa.service.EmployeeJPA;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MainJPA {

    @SneakyThrows
    public static void main(String[] args) {
        EmployeeHibernate hibernate = new EmployeeHibernate();
        EmployeeJPA jpa = new EmployeeJPA();
        Employee employee1 = new Employee(100L, "Phillipe", "Chef");
        Employee employee2 = new Employee(200L, "Jaylen", "Assistant");

        hibernate.insert(employee1);
        hibernate.insert(employee2);
        CompletableFuture<Employee> emp1 = hibernate.findById(employee1.getId());
        log.info("Inserted employee: {}", emp1.get());
        employee1.setOccupation("Master Chef");
        hibernate.update(employee1, employee1.getId());
        CompletableFuture<List<Employee>> employeesList1 = hibernate.findAll();
        log.info("List of {} employees: {}", employeesList1.get().size(), employeesList1.get());
        hibernate.deleteById(employee1.getId());
        log.info("List of {} employees after deletion: {}", hibernate.findAll().get().size(), hibernate.findAll().get());
        hibernate.deleteAll();
        log.info("List of {} employees after deletion: {}", hibernate.findAll().get().size(), hibernate.findAll());
        Hibernate.shutdown();

        jpa.insert(employee2);
        jpa.insert(employee1);
        CompletableFuture<Employee> emp2 = jpa.findById(employee2.getId());
        log.info("Inserted employee: {}", emp2.get());
        employee2.setOccupation("Professor");
        jpa.update(employee2, employee1.getId());
        CompletableFuture<List<Employee>> employeesList2 = jpa.findAll();
        log.info("List of {} employees: {}", employeesList2.get().size(), employeesList2.get());
        jpa.deleteById(employee2.getId());
        log.info("List of {} employees after deletion: {}", jpa.findAll().get().size(), jpa.findAll().get());
        jpa.deleteAll();
        log.info("List of {} employees after deletion: {}", jpa.findAll().get().size(), jpa.findAll().get());
        Jpa.closeEntityManager();
    }
}
