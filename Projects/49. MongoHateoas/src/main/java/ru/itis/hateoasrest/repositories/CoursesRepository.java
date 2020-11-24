package ru.itis.hateoasrest.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.hateoasrest.models.Course;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 23.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CoursesRepository extends MongoRepository<Course, String> {

    @RestResource(path = "inactives", rel = "inactives")
    @Query(value = "{active: false, $or: [{keywords: ?0}, {studentsCount: {$lt: ?1 }}]}")
    List<Course> find(@Param("keywords") List<String> keywords, @Param("studentsCount") int maxStudentsCount, Pageable pageable);
}
