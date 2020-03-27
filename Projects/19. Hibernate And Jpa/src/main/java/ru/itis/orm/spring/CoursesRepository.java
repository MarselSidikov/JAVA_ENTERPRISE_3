package ru.itis.orm.spring;

import ru.itis.orm.Course;

public interface CoursesRepository {
    void save(Course course);
}
