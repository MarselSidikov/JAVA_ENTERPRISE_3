package ru.itis.hateoas.hateoasservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.hateoasservice.models.Student;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}
