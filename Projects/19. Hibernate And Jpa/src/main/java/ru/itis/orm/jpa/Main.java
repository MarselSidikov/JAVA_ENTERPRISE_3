package ru.itis.orm.jpa;

import ru.itis.orm.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ru.itis.orm.education_center");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Course course = Course.builder()
                .title("Java Course")
                .build();
        entityManager.persist(course);
        entityTransaction.commit();
    }
}
