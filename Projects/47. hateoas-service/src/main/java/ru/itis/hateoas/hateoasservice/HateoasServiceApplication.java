package ru.itis.hateoas.hateoasservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.hateoas.hateoasservice.models.Course;
import ru.itis.hateoas.hateoasservice.models.Lesson;
import ru.itis.hateoas.hateoasservice.models.User;
import ru.itis.hateoas.hateoasservice.repositories.CoursesRepository;
import ru.itis.hateoas.hateoasservice.repositories.LessonsRepository;
import ru.itis.hateoas.hateoasservice.repositories.UsersRepository;

import java.util.Collections;

import static java.util.Arrays.asList;

@SpringBootApplication
public class HateoasServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasServiceApplication.class, args);

        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);
        LessonsRepository lessonsRepository = context.getBean(LessonsRepository.class);
        UsersRepository studentsRepository = context.getBean(UsersRepository.class);

        Course javaLab = Course.builder()
                .description("Курс по разработке на Java")
                .title("JavaLab")
                .state("Deleted")
                .build();

        Course dataLab = Course.builder()
                .description("Курс по Базам данных")
                .title("DataLab")
                .state("Draft")
                .build();

        coursesRepository.saveAll(asList(
                javaLab, dataLab
        ));

        Lesson firstJavaLabLesson = Lesson.builder()
                .title("Rest Data Repository")
                .rate(100)
                .course(javaLab)
                .build();

        Lesson secondJavaLabLesson = Lesson.builder()
                .title("HATEOAS")
                .rate(1)
                .course(javaLab)
                .build();

        Lesson firstDataLabLesson = Lesson.builder()
                .title("Парсим сайты")
                .rate(100)
                .course(dataLab)
                .build();

        Lesson secondDataLabLesson = Lesson.builder()
                .title("Что-то с таблицами они проходили")
                .rate(146)
                .course(dataLab)
                .build();

        lessonsRepository.saveAll(asList(firstJavaLabLesson,
                secondJavaLabLesson,
                firstDataLabLesson,
                secondDataLabLesson));

        User daria = User.builder()
                .firstName("Дария")
                .lastName("Шагиева")
                .courses(asList(javaLab, dataLab))
                .build();

        User emil = User.builder()
                .firstName("Эмиль")
                .lastName("Аминов")
                .courses(Collections.singletonList(javaLab))
                .build();

        studentsRepository.saveAll(asList(emil, daria));
    }

}
