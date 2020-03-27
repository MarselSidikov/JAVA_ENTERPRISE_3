package ru.itis.orm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.orm.Course;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        CoursesRepository coursesRepositoryJpa = context.getBean(CoursesRepository.class);
        coursesRepositoryJpa.save(Course.builder()
                .title("Лучший в мире курс")
                .build());

    }
}
