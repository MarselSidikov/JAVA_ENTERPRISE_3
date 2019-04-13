package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private Connection connection;

    //language=SQL
    private final String SQL_INSERT_USER = "insert into " +
            "taxi_user (first_name, last_name, age, is_man) values (?, ?, ?, ?);";

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<User> userRowMapper = row -> {
        Long id = row.getLong("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        Boolean isMan = row.getBoolean("is_man");
        Integer age = row.getObject("age", Integer.class);
        return new User(id, firstName, lastName, age, isMan);
    };

    @Override
    public void save(User model) {
        // TODO: добавить try-with-resources
        try {
            // TODO: так не делать. SQL-инъекция
//            Statement statement = connection.createStatement();
//            //language=SQL
//            String query = "insert into taxi_user (first_name, last_name, is_man, age) " +
//                    "values ('" + model.getFirstName() + "','" + model.getLastName() + "'," + model.getMan()
//                    + "," + model.getAge() + ");";
//            System.out.println(query);
//            statement.executeUpdate(query);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getLastName());
            statement.setInt(3, model.getAge());
            statement.setBoolean(4, model.getMan());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }

            ResultSet generatesKeys = statement.getGeneratedKeys();

            if (generatesKeys.next()) {
                model.setId(generatesKeys.getLong("id"));
            } else {
                throw new SQLException();
            }
            statement.close();
            generatesKeys.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<User> find(Long id) {
        User user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from taxi_user where id = " + id + ";");

            if (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
            }
            statement.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from taxi_user");

            while (resultSet.next()) {
                User user = userRowMapper.mapRow(resultSet);
                result.add(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    @Override
    public Optional<User> findOneByFirstName(String firstName) {
        return Optional.empty();
    }
}
