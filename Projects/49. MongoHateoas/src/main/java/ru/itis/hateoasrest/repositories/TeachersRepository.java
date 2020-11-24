package ru.itis.hateoasrest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.itis.hateoasrest.models.Teacher;

/**
 * 23.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TeachersRepository extends PagingAndSortingRepository<Teacher, String> {
}
