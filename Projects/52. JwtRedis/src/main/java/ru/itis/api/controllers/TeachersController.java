package ru.itis.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.api.dto.TeacherDto;
import ru.itis.api.services.TeachersService;

import java.util.List;

/**
 * 24.03.2021
 * 04. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDto>> getTeachers() {
        return ResponseEntity.ok(teachersService.getAllTeachers());
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacher) {
        return ResponseEntity.ok(teachersService.addTeacher(teacher));
    }
}
