package ru.itis.mongo.spring;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 21.11.2020
 * MongoDb
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Course {
    private String _id;
    private Integer studentsCount;
    private Integer hours;
    private List<String> keywords;
    private Map<String, String> teachers;

    public Course() {
    }

    public Course(String _id, Integer studentsCount, Integer hours, List<String> keywords, Map<String, String> teachers) {
        this._id = _id;
        this.studentsCount = studentsCount;
        this.hours = hours;
        this.keywords = keywords;
        this.teachers = teachers;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("studentsCount=" + studentsCount)
                .add("hours=" + hours)
                .add("keywords=" + keywords)
                .add("teachers=" + teachers)
                .toString();
    }

    public Map<String, String> getTeachers() {
        return teachers;
    }

    public void setTeachers(Map<String, String> teachers) {
        this.teachers = teachers;
    }
}
