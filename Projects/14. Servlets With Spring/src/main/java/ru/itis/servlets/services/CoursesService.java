package ru.itis.servlets.services;

import ru.itis.servlets.models.Course;

import java.util.List;

public interface CoursesService {
    List<Course> getAllCourses();
}
