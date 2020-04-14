package ru.itis.servlets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.servlets.models.Course;
import ru.itis.servlets.services.CoursesService;

import java.util.List;

@RestController
@Profile("rest")
public class CoursesRestController {

    @Autowired
    private CoursesService coursesService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(coursesService.getAllCourses());
    }
}
