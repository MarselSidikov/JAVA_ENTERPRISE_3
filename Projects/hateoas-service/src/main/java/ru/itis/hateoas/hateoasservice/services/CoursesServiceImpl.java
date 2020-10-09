package ru.itis.hateoas.hateoasservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.hateoas.hateoasservice.models.Course;
import ru.itis.hateoas.hateoasservice.repositories.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public Course publish(Long courseId) {
        Course course = coursesRepository.findById(courseId).orElseThrow(IllegalArgumentException::new);
        course.publish();
        coursesRepository.save(course);
        return course;
    }
}
