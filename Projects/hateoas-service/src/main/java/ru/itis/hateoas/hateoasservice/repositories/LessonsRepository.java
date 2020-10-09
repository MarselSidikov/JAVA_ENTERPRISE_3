package ru.itis.hateoas.hateoasservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.hateoasservice.models.Lesson;


public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}
