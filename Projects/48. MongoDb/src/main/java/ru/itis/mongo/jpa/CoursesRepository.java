package ru.itis.mongo.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 23.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CoursesRepository extends MongoRepository<Course, String> {

    @Query(value = "{active: false, $or: [{keywords: ?keywords}, {studentsCount: {$lt: ?1}}]}")
    List<Course> find(@Param("keywords") List<String> keywords, @Param("studentsCount") int maxStudentsCount);
}
