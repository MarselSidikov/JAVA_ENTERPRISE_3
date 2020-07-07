package ru.itis.service.controllers;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.service.dto.LessonDto;
import ru.itis.service.models.Course;
import ru.itis.service.models.Lesson;
import ru.itis.service.repositories.CoursesRepository;
import ru.itis.service.repositories.LessonsRepository;

import java.util.List;

import static ru.itis.service.dto.LessonDto.from;

/**
 * 03.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class CoursesController {

    @Autowired
    private LessonsRepository lessonsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @ApiOperation(value = "Добавление урока в курс")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление"),
            @ApiResponse(code = 403, message = "Неверный токен авторизации")
    })
    @ApiImplicitParam(name = "token", value = "Токен авторизации", required = true, dataType = "string", paramType = "header")
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/courses/{course-id}/lessons")
    public ResponseEntity<List<LessonDto>> addLesson(@ApiParam(value = "Идентификатор курса", required = true) @PathVariable("course-id") Long courseId, @RequestBody LessonDto lesson) {
        Course course = coursesRepository.getOne(courseId);
        Lesson newLesson = Lesson.builder()
                .name(lesson.getName())
                .course(course)
                .build();
        lessonsRepository.save(newLesson);
        return ResponseEntity.ok(from(lessonsRepository.findAllByCourse(course)));
    }
}
