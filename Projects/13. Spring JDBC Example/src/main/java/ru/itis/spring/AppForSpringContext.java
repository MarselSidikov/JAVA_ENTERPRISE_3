package ru.itis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.spring.repositories.CoursesRepository;

import javax.sql.DataSource;

public class AppForSpringContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        DataSource dataSource = context.getBean(DataSource.class);
//        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);

        System.out.println(coursesRepository.findAll());
    }
}
