package ru.itis.mongo.spring;

import org.bson.Document;

import java.util.Map;
import java.util.StringJoiner;

/**
 * 21.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

public class Teacher {
    private String _id;
    private String firstName;
    private String lastName;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher(String _id, String firstName, String lastName) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Teacher.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .toString();
    }
}
