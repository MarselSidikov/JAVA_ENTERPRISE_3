package ru.itis;

import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Optional;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String url = properties.getProperty("db.url");

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);

        Optional<User> userCandidate = usersRepository.find(10L);

        if (userCandidate.isPresent()) {
            System.out.println(userCandidate.get());
        } else {
            System.out.println("Ничего не найдено");
        }

        System.out.println(usersRepository.findAll());
    }
}
