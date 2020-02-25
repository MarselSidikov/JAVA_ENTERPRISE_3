package ru.itis.spring.repositories;

import ru.itis.spring.models.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoursesRepositoryJdbcImpl implements CoursesRepository {

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from course where id = ?";
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from course";
    //language=SQL
    private static final String SQL_INSERT = "insert into course(title) values (?)";

    private Connection connection;

    private RowMapper<Course> courseRowMapper = row ->
            Course.builder()
                    .id(row.getLong("id"))
                    .title(row.getString("title"))
                    .build();


    public CoursesRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public Optional<Course> find(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            Optional<Course> courseResult = Optional.empty();
            if (result.next()) {
                Course course =  courseRowMapper.mapRow(result);
                courseResult = Optional.of(course);
            }
            result.close();
            statement.close();
            return courseResult;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Course> findAll() {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet result = statement.executeQuery();
            List<Course> courses = new ArrayList<>();
            while (result.next()) {
                Course course = courseRowMapper.mapRow(result);
                courses.add(course);
            }
            result.close();
            statement.close();
            return courses;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void save(Course entity) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getTitle());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating course failed");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Crating course failed");
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void delete(Long id) {

    }
}
