package com.database;

import com.database.jpa.config.Hibernate;
import com.database.jpa.config.Jpa;
import com.database.jpa.model.Employee;
import com.database.jpa.service.EmployeeHibernateImpl;
import com.database.jpa.service.EmployeeJPAImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MainJPA {

    public static void main(String[] args) {
        EmployeeHibernateImpl hibernate = new EmployeeHibernateImpl();
        EmployeeJPAImpl jpa = new EmployeeJPAImpl();
        Employee employee1 = new Employee(100L, "Phillipe", "Chef");
        Employee employee2 = new Employee(200L, "Jaylen", "Assistant");

        hibernate.insert(employee1);
        Employee emp1 = hibernate.findById(employee1.getId());
        log.info("Inserted employee: {}", emp1);
        employee1.setOccupation("Master Chef");
        hibernate.update(employee1);
        List<Employee> employeesList1 = hibernate.findAll();
        log.info("List of {} employees: {}", employeesList1.size(), employeesList1);
        hibernate.deleteById(employee1.getId());
        log.info("List of {} employees after deletion: {}", hibernate.findAll().size(), hibernate.findAll());
        hibernate.deleteAll();
        log.info("List of {} employees after deletion: {}", hibernate.findAll().size(), hibernate.findAll());
        Hibernate.shutdown();

        jpa.insert(employee2);
        Employee emp2 = jpa.findById(employee2.getId());
        log.info("Inserted employee: {}", emp2);
        employee2.setOccupation("Professor");
        jpa.update(employee2);
        List<Employee> employeesList2 = jpa.findAll();
        log.info("List of {} employees: {}", employeesList2.size(), employeesList2);
        jpa.deleteById(employee2.getId());
        log.info("List of {} employees after deletion: {}", jpa.findAll().size(), jpa.findAll());
        jpa.deleteAll();
        log.info("List of {} employees after deletion: {}", jpa.findAll().size(), jpa.findAll());
        Jpa.closeEntityManager();
    }
}
