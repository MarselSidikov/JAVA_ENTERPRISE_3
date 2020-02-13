package ru.itdrive.jdbc.statements.repositories;

import ru.itdrive.jdbc.statements.models.Student;

public interface StudentsRepository extends CrudRepository<Student> {
    Student findByFirstName(String firstName);
}
