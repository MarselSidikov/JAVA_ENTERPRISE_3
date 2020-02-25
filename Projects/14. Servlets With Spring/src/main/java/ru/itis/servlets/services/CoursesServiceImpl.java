package ru.itis.servlets.services;

import ru.itis.servlets.models.Course;
import ru.itis.servlets.repositories.CoursesRepository;

import java.util.List;

public class CoursesServiceImpl implements CoursesService {

    private CoursesRepository coursesRepository;

    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }
}
