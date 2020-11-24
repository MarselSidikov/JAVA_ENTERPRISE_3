package ru.itis.mongo.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 23.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoriesConfig.class);
        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);
        TeachersRepository teachersRepository = context.getBean(TeachersRepository.class);

        Teacher marsel = Teacher.builder()
                .firstName("Марсель")
                .lastName("Сидиков")
                .build();

        Teacher kamil = Teacher.builder()
                .firstName("Камиль")
                .lastName("Хадиев")
                .build();

//        teachersRepository.save(marsel);
//        teachersRepository.save(kamil);
//        Course course = coursesRepository.findById("5fa588666476304d27452aa5").orElseThrow(IllegalArgumentException::new);
//        List<Teacher> teachers = Arrays.asList(marsel, kamil);
//        course.setTeachers(teachers);
//        coursesRepository.save(course);
//        System.out.println(coursesRepository.findAllByActiveIsTrueAndKeywordsContainsAndStudentsCountBefore("java core", 35));
        System.out.println(coursesRepository.find(Arrays.asList("java core"), 100));
    }
}
