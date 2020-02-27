package ru.itis.servlets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.servlets.models.Course;
import ru.itis.servlets.repositories.CoursesRepository;

import java.util.List;

@Component
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }
}
