package ru.itis.api.services;


import ru.itis.api.dto.TeacherDto;

import java.util.List;

/**
 * 24.03.2021
 * 04. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TeachersService {
    List<TeacherDto> getAllTeachers();

    TeacherDto addTeacher(TeacherDto teacher);
}
