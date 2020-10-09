package ru.itis.hateoas.hateoasservice.services;

import ru.itis.hateoas.hateoasservice.models.Course;

public interface CoursesService {
    Course publish(Long courseId);
}
