package ru.itis.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.service.models.Course;
import ru.itis.service.models.Lesson;
import ru.itis.service.models.User;

import java.util.List;

/**
 * 03.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface LessonsRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByCourse(Course course);
}
