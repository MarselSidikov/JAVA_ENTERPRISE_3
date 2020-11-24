package ru.itis.mongo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * 21.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleMongoConfig.class);
        MongoTemplate template = context.getBean(MongoTemplate.class);
//        Teacher teacher = new Teacher("Преподаватель", "Преподавателев");
//        template.save(teacher, "new_teacher");

        // db.courses.find({active: true, $or: [{keywords: 'java core'}, {studentsCount: {$lt: 35}}]})
        List<Course> courses = template.find(new Query(
                where("active").is(true)
                        .orOperator(where("keywords").is("java core"),
                                where("studentsCount").lt(35))), Course.class, "courses");
        System.out.println(courses);

    }
}
