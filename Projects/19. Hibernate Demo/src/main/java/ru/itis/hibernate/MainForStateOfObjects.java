package ru.itis.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForStateOfObjects {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Course course = Course.builder()
                .title("Java")
                .build();
        // TRANSIENT

        session.save(course);
        // PERSISTENT
        transaction.commit();
        transaction = session.beginTransaction();
        // PERSISTENT
        course.setTitle("НОВОЕ НАЗВАНИЕ");
        transaction.commit();

        session.close();

        // DETACHED
        System.out.println(course);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        course.setTitle("ЕЩЕ одно новое название");
        session.saveOrUpdate(course);
        transaction.commit();
    }
}
