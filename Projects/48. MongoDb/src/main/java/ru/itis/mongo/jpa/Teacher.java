package ru.itis.mongo.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.StringJoiner;

/**
 * 21.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "teachers")
public class Teacher {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
}
