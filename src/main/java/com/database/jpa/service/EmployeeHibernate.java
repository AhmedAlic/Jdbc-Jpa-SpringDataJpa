package com.database.jpa.service;

import com.database.EmployeeCrud;
import com.database.jpa.config.Hibernate;
import com.database.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class EmployeeHibernate implements EmployeeCrud {

    @Override
    public CompletableFuture<List<Employee>> findAll() {
        List<Employee> list = new ArrayList<>();
        try (Session session = Hibernate.getSession()) {
            list = session.createQuery("FROM Employee", Employee.class)
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture(list);
    }

    @Override
    public CompletableFuture<Employee> findById(Long id) {
        Employee employee = null;
        try (Session session = Hibernate.getSession()) {
            employee = session.get(Employee.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture(employee);
    }

    @Override
    public CompletableFuture<Employee> insert(Employee employee) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return CompletableFuture.completedFuture(employee);
    }

    @Override
    public CompletableFuture<Employee> update(Employee employee, Long id) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSession()) {
            transaction = session.beginTransaction();
            Employee existingEmployee = session.get(Employee.class, id);
            existingEmployee.setName(employee.getName());
            existingEmployee.setOccupation(employee.getOccupation());
            session.saveOrUpdate(existingEmployee);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return CompletableFuture.completedFuture(employee);
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            session.delete(employee);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = Hibernate.getSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("DELETE  FROM Employee", Employee.class).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
