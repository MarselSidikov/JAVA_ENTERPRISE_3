package ru.itis.orm.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.itis.orm.Course;
import ru.itis.orm.Lesson;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course = Course.builder()
                .title("Java")
                .build();

        Lesson lesson = Lesson.builder()
                .name("Hibernate")
                .course(course)
                .build();

        session.save(lesson);
        session.save(course);
        course.setTitle("СТАРЫЙ КУРС");
        transaction.commit();

//        session.close();
//        session = sessionFactory.openSession();
        session.clear();
        Query<Course> courseQuery = session.createQuery("from Course", Course.class);
        List<Course> courses = courseQuery.getResultList();
        System.out.println(courses);
    }
}
