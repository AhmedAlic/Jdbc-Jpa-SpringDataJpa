package com.database.jpa.service;

import com.database.EmployeeCrud;
import com.database.jpa.config.Jpa;
import com.database.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EmployeeJPA implements EmployeeCrud {

    @PersistenceContext(unitName = "employee_entity_manager")
    private EntityManager entityManager;

    @Override
    public CompletableFuture<List<Employee>> findAll() {
        entityManager = Jpa.getEntityManager();
        List<Employee> list = entityManager.createQuery("FROM Employee", Employee.class)
                .getResultList();
        return CompletableFuture.completedFuture(list);
    }

    @Override
    public CompletableFuture<Employee> findById(Long id) {
        entityManager = Jpa.getEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.detach(employee);
        return CompletableFuture.completedFuture(employee);
    }

    @Override
    public CompletableFuture<Employee> insert(Employee employee) {
        entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return CompletableFuture.completedFuture(employee);
    }

    @Override
    public CompletableFuture<Employee> update(Employee employee, Long id) {
        entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Employee existingEmployee = entityManager.find(Employee.class, id);
            existingEmployee.setName(employee.getName());
            existingEmployee.setOccupation(employee.getOccupation());
            entityManager.merge(existingEmployee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return CompletableFuture.completedFuture(employee);
    }

    @Override
    public void deleteById(Long id) {
        entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Employee emp = entityManager.find(Employee.class, id);
            entityManager.remove(emp);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void deleteAll() {
        entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("DELETE  FROM Employee", Employee.class).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
