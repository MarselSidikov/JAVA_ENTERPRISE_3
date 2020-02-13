package ru.itdrive.jdbc.statements.repositories;

import ru.itdrive.jdbc.statements.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsRepositoryJdbcImpl implements StudentsRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from student";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from student where id = ";

    //language=SQL
    private static final String SQL_INSERT_STUDENT = "insert into student(first_name, last_name) values (?, ?)";

    private Connection connection;

    private RowMapper<Student> studentRowMapper = new RowMapper<Student>() {
        public Student mapRow(ResultSet row) throws SQLException {
            return new Student(
                    row.getInt("id"),
                    row.getString("first_name"),
                    row.getString("last_name"),
                    row.getInt("age"),
                    row.getBoolean("is_active")
            );
        }
    };

    public StudentsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public Student findByFirstName(String firstName) {
        return null;
    }

    public void save(Student object) {
        try {
//            Statement statement = connection.createStatement();
//            String sql = "insert into student (first_name, last_name) values ('" + object.getFirstName() + "','" + object.getLastName() + "');";
//            System.out.println(sql);
//            statement.executeUpdate(sql);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_STUDENT);
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void update(Student object) {

    }

    public void delete(Integer id) {

    }

    public Student find(Integer id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_BY_ID + id);
            resultSet.next();
            statement.close();
            return studentRowMapper.mapRow(resultSet);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Student> findAll() {
        try {
            List<Student> result = new ArrayList<Student>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Student student = studentRowMapper.mapRow(resultSet);
                result.add(student);
            }
            statement.close();
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
