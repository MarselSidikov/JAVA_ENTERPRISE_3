package ru.itis.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.api.dto.TeacherDto;
import ru.itis.api.models.Teacher;
import ru.itis.api.repository.TeachersRepository;

import java.util.List;

import static ru.itis.api.dto.TeacherDto.*;
/**
 * 24.03.2021
 * 04. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    @Override
    public List<TeacherDto> getAllTeachers() {
        return from(teachersRepository.findAllByIsDeletedIsNull());
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacher) {
        Teacher newTeacher = Teacher.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();

        teachersRepository.save(newTeacher);
        return from(newTeacher);
    }
}
