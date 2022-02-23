package com.database.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("employee_entity_manager");
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager() {
        entityManagerFactory.close();
    }

    public static boolean isActive() {
        return entityManagerFactory.isOpen();
    }
}
