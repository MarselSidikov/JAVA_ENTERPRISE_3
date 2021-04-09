package ru.itis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.api.models.Teacher;
import java.util.List;

/**
 * 24.03.2021
 * 04. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TeachersRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByIsDeletedIsNull();
}
