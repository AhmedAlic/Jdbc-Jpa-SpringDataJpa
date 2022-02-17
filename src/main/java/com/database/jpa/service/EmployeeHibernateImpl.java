package com.database.jpa.service;

import com.database.jpa.EmployeeDAO;
import com.database.jpa.config.Hibernate;
import com.database.jpa.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EmployeeHibernateImpl implements EmployeeDAO {

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        try (Session session = Hibernate.getSession()) {
            list = session.createQuery("FROM Employee", Employee.class)
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = null;
        try (Session session = Hibernate.getSession()) {
            employee = session.get(Employee.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    @Override
    public void insert(Employee employee) {
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
    }

    @Override
    public void update(Employee employee) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
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
}
