package ru.itdrive.jdbc.statements;

import ru.itdrive.jdbc.statements.models.Student;
import ru.itdrive.jdbc.statements.repositories.StudentsRepository;
import ru.itdrive.jdbc.statements.repositories.StudentsRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class MainForRepositories {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/education_center";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        StudentsRepository repository = new StudentsRepositoryJdbcImpl(connection);

        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        Student student = Student.builder()
                .lastName(lastName)
                .firstName(firstName)
                .build();

        repository.save(student);
    }
}
