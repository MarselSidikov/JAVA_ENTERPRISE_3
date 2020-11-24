package ru.itis.mongo.driver;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

/**
 * 14.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("education");
        MongoCollection<Document> collection = database.getCollection("courses");

//        collection.find().forEach(document -> System.out.println(document.getBoolean("active")));


     // db.courses.find({active: true, $or: [{keywords: 'java core'}, {studentsCount: {$lt: 35}}]})
//
        Document searchQuery = new Document();
//
        searchQuery
                .append("active", true)
                .append("$or", Arrays.asList(
                        new Document("keywords", "java core"),
                        new Document("studentsCount", new Document("$lt", 53))));

//        FindIterable<Document> resultDocuments = collection.find(searchQuery);

//
//        FindIterable<Document> resultDocuments = collection.find(searchQuery)
//                .projection(new Document("hours", 1)
//                        .append("active", 1)
//                        .append("studentsCount", 1)
//                        .append("keywords", 1)
//                        .append("_id", 0));

//        FindIterable<Document> resultDocuments = collection.find(
//                and(new Document("active", true),
//                    or(new Document("keywords", "java core"),
//                            lt("studentsCount", 35))));

        FindIterable<Document> resultDocuments = collection.find(searchQuery)
                .projection(fields(include("studentsCount", "hours", "active"), excludeId()));

        for (Document document : resultDocuments) {
            System.out.println(document.toJson());
        }
    }
}
