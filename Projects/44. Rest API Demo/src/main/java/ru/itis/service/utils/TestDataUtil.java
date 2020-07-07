package ru.itis.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.service.models.*;
import ru.itis.service.repositories.CoursesRepository;
import ru.itis.service.repositories.DisciplinesRepository;
import ru.itis.service.repositories.LessonsRepository;
import ru.itis.service.repositories.UsersRepository;

import java.util.Arrays;
import java.util.Collections;

/**
 * 03.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class TestDataUtil {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private LessonsRepository lessonsRepository;

    @Autowired
    private DisciplinesRepository disciplinesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void initializeData() {

        Discipline languages = Discipline.builder()
                .name("Languages")
                .build();

        Discipline it = Discipline.builder()
                .name("IT")
                .build();

        disciplinesRepository.save(languages);
        disciplinesRepository.save(it);

        Course java = Course.builder()
                .discipline(it)
                .title("java")
                .build();

        Course english = Course.builder()
                .discipline(languages)
                .title("English")
                .build();

        coursesRepository.save(java);
        coursesRepository.save(english);

        User student1 = User.builder()
                .email("student1@gmail.com")
                .courses(Collections.singletonList(java))
                .build();
        User student2 = User.builder()
                .email("student2@gmail.com")
                .hashPassword(passwordEncoder.encode("qwerty007"))
                .courses(Collections.singletonList(english))
                .tokens(Arrays.asList("token3", "token4"))
                .authority(Authority.USER)
                .build();

        User student3 = User.builder()
                .email("student3@gmail.com")
                .hashPassword(passwordEncoder.encode("qwerty008"))
                .courses(Collections.singletonList(java))
                .tokens(Arrays.asList("token1", "token2"))
                .authority(Authority.ADMIN)
                .build();

        usersRepository.save(student1);
        usersRepository.save(student2);
        usersRepository.save(student3);


        Lesson helloWorld = Lesson.builder()
                .course(java)
                .name("Hello World")
                .build();

        Lesson springDataJpa = Lesson.builder()
                .course(java)
                .name("Spring Data Jpa")
                .build();

        Lesson vremena = Lesson.builder()
                .course(english)
                .name("Vremena")
                .build();

        Lesson englishMemes = Lesson.builder()
                .course(english)
                .name("English Memes")
                .build();

        lessonsRepository.save(helloWorld);
        lessonsRepository.save(springDataJpa);
        lessonsRepository.save(vremena);
        lessonsRepository.save(englishMemes);
    }

}
