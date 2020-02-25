package ru.itis.spring;

import ru.itis.spring.models.Course;
import ru.itis.spring.models.Lesson;
import ru.itis.spring.repositories.CoursesRepository;
import ru.itis.spring.repositories.CoursesRepositoryJdbcImpl;
import ru.itis.spring.repositories.LessonsRepository;
import ru.itis.spring.repositories.LessonsRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class App {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/education_center";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        LessonsRepository lessonsRepository = new LessonsRepositoryJdbcImpl(connection);
        CoursesRepository coursesRepository = new CoursesRepositoryJdbcImpl(connection);

        List<Lesson> lessons = lessonsRepository.findAll();
        List<Course> courses = coursesRepository.findAll();

        lessonsRepository.find(2L).ifPresent(System.out::println);
        coursesRepository.find(1L).ifPresent(System.out::println);

        System.out.println(lessons);
        System.out.println(courses);

        Lesson lesson = Lesson.builder()
                .name("Spring JDBC").build();

        lessonsRepository.save(lesson);
        System.out.println(lesson);
    }
}
