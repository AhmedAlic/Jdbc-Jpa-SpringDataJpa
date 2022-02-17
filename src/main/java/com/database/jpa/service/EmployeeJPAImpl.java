package com.database.jpa.service;

import com.database.jpa.EmployeeDAO;
import com.database.jpa.config.Jpa;
import com.database.jpa.model.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeJPAImpl implements EmployeeDAO {

    @Override
    public List<Employee> findAll() {
        EntityManager entityManager = Jpa.getEntityManager();
        return entityManager.createQuery("FROM Employee", Employee.class)
                .getResultList();
    }

    @Override
    public Employee findById(Long id) {
        EntityManager entityManager = Jpa.getEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.detach(employee);
        return employee;
    }

    @Override
    public void insert(Employee employee) {
        EntityManager entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Employee employee) {
        EntityManager entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Employee emp = entityManager.find(Employee.class, id);
            entityManager.remove(emp);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
