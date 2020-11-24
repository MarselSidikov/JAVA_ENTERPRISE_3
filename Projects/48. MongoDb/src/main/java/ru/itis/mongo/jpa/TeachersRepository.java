package ru.itis.mongo.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 23.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TeachersRepository extends PagingAndSortingRepository<Teacher, String> {
}
