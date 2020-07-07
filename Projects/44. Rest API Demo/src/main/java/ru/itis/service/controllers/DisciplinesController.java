package ru.itis.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.service.dto.CourseDto;
import ru.itis.service.models.Course;
import ru.itis.service.models.Discipline;
import ru.itis.service.repositories.DisciplinesRepository;

import java.util.List;

import static ru.itis.service.dto.CourseDto.from;

/**
 * 03.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class DisciplinesController {

    @Autowired
    private DisciplinesRepository disciplinesRepository;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/disciplines/{discipline-id}/courses")
    public ResponseEntity<List<CourseDto>> getCoursesOfDiscipline(@PathVariable("discipline-id") Long disciplineId) {
        Discipline discipline = disciplinesRepository.getOne(disciplineId);
        return ResponseEntity.ok(from(discipline.getCourses()));
    }
}
