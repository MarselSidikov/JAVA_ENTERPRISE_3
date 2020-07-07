package ru.itis.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.service.models.Course;
import ru.itis.service.models.User;

/**
 * 03.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CoursesRepository extends JpaRepository<Course, Long> {
}
