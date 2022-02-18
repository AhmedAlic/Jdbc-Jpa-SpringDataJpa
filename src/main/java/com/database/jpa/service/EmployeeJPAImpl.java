package com.database.jpa.service;

import com.database.jpa.EmployeeDAO;
import com.database.jpa.config.Jpa;
import com.database.jpa.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class EmployeeJPAImpl implements EmployeeDAO {

    @PersistenceContext(unitName = "employee_entity_manager")
    private EntityManager entityManager;

    @Override
    @Transactional()
    public List<Employee> findAll() {
        entityManager = Jpa.getEntityManager();
        return entityManager.createQuery("FROM Employee", Employee.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Employee findById(Long id) {
        entityManager = Jpa.getEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.detach(employee);
        return employee;
    }

    @Override
    @Transactional
    public void insert(Employee employee) {
        entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        entityManager = Jpa.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        entityManager = Jpa.getEntityManager();
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
