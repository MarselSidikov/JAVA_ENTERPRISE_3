package ru.itis.mongo.jpa;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 21.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@Document(collection = "courses")
public class Course {
    @Id
    private String _id;
    private Integer studentsCount;
    private Integer hours;
    private List<String> keywords;
    private Boolean active;
    @DBRef
    private List<Teacher> teachers;
}
