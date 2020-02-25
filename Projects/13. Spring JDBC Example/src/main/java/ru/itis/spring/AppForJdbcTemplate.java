package ru.itis.spring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.spring.models.Course;
import ru.itis.spring.repositories.CoursesRepository;
import ru.itis.spring.repositories.spring.CoursesRepositoryJdbcTemplateImpl;

import java.util.Optional;

public class AppForJdbcTemplate {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/education_center";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername(DB_USER);
//        dataSource.setPassword(DB_PASSWORD);
//        dataSource.setUrl(DB_URL);

        HikariConfig config = new HikariConfig();
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);
        config.setJdbcUrl(DB_URL);
        HikariDataSource dataSource = new HikariDataSource(config);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        CoursesRepository coursesRepository = new CoursesRepositoryJdbcTemplateImpl(jdbcTemplate);
        Optional<Course> courseOptional = coursesRepository.find(1L);
        System.out.println(courseOptional.get());

    }
}
