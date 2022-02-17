package com.database.jpa.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
/*  Configuration with hibernate.properties
            Configuration configuration = new Configuration();
            sessionFactory = configuration.buildSessionFactory();
            configuration.addAnnotatedClass(Employee.class);
            sessionFactory = configuration.buildSessionFactory();
    Programmatic configuration
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "postgres123");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
            configuration.addAnnotatedClass(Employee.class);  */
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        sessionFactory.close();
    }

    public static boolean isActive() {
        return sessionFactory.isOpen();
    }
}
