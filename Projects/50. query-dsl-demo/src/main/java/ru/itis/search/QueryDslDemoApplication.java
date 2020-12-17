package ru.itis.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.search.models.*;
import ru.itis.search.repositories.AccountsRepository;
import ru.itis.search.repositories.CommentsRepository;
import ru.itis.search.repositories.CoursesRepository;
import ru.itis.search.repositories.LessonsRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;

// https://www.logicbig.com/tutorials/spring-framework/spring-data/web-query-dsl-collection-properties.html
@SpringBootApplication
public class QueryDslDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QueryDslDemoApplication.class, args);

//        AccountsRepository accountsRepository = context.getBean(AccountsRepository.class);
//        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);
//        LessonsRepository lessonsRepository = context.getBean(LessonsRepository.class);
//        CommentsRepository commentsRepository = context.getBean(CommentsRepository.class);
//
//
//        User admin = User.builder()
//                .firstName("Администратор")
//                .lastName("Центра")
//                .email("admin@center.com")
//                .role(Role.ADMIN)
//                .phone("12345")
//                .state(UserState.CONFIRMED)
//                .build();
//
//        accountsRepository.save(admin);
//
//        User student1 = User.builder()
//                .firstName("Имя 1")
//                .lastName("Фамилия 1")
//                .creator(admin)
//                .email("student1@center.com")
//                .phone("678910")
//                .role(Role.STUDENT)
//                .state(UserState.CONFIRMED)
//                .build();
//
//        User student2 = User.builder()
//                .firstName("Имя 2")
//                .lastName("Фамилия 2")
//                .creator(admin)
//                .email("student2@center.com")
//                .phone("1112131415")
//                .role(Role.STUDENT)
//                .state(UserState.DELETED)
//                .build();
//
//        User student3 = User.builder()
//                .firstName("Имя 3")
//                .lastName("Фамилия 3")
//                .creator(admin)
//                .email("student3@center.com")
//                .phone("1617181920")
//                .role(Role.STUDENT)
//                .state(UserState.NOT_CONFIRMED)
//                .build();
//
//        User teacher1 = User.builder()
//                .firstName("Педагог 1")
//                .lastName("Педагог 1")
//                .creator(admin)
//                .email("teacher1@center.com")
//                .phone("777")
//                .role(Role.TEACHER)
//                .state(UserState.CONFIRMED)
//                .build();
//
//        User teacher2 = User.builder()
//                .firstName("Педагог 2")
//                .lastName("Педагог 2")
//                .creator(admin)
//                .email("teacher2@center.com")
//                .phone("888")
//                .role(Role.TEACHER)
//                .state(UserState.CONFIRMED)
//                .build();
//
//        accountsRepository.save(student1);
//        accountsRepository.save(student2);
//        accountsRepository.save(student3);
//        accountsRepository.save(teacher1);
//        accountsRepository.save(teacher2);
//
//        Course java = Course.builder()
//                .description("Курсы по разработке на Java")
//                .startDate(LocalDate.of(2020, 7, 1))
//                .finishDate(LocalDate.of(2020, 9, 1))
//                .name("Java Spring")
//                .teacher(teacher1)
//                .partnerCreator(admin)
//                .build();
//
//        Course db = Course.builder()
//                .description("Курсы по базам данных")
//                .startDate(LocalDate.of(2020, 1, 1))
//                .finishDate(LocalDate.of(2020, 5, 1))
//                .name("PostgreSQL")
//                .teacher(teacher2)
//                .partnerCreator(admin)
//                .build();
//
//        coursesRepository.save(java);
//        coursesRepository.save(db);
//
//        student1.setCourses(Collections.singletonList(java));
//        student2.setCourses(Arrays.asList(java, db));
//        student3.setCourses(Collections.singletonList(db));
//
//        accountsRepository.save(student1);
//        accountsRepository.save(student2);
//        accountsRepository.save(student3);
//
//        Lesson javaLesson1 = Lesson.builder()
//                .course(java)
//                .startTime(LocalTime.of(9, 15))
//                .finishTime(LocalTime.of(10, 15))
//                .build();
//
//        Lesson javaLesson2 = Lesson.builder()
//                .course(java)
//                .startTime(LocalTime.of(15, 20))
//                .finishTime(LocalTime.of(16, 10))
//                .build();
//
//        Lesson dbLesson1 = Lesson.builder()
//                .course(db)
//                .startTime(LocalTime.of(8, 5))
//                .finishTime(LocalTime.of(9, 0))
//                .build();
//
//        Lesson dbLesson2 = Lesson.builder()
//                .course(db)
//                .startTime(LocalTime.of(16, 5))
//                .finishTime(LocalTime.of(17, 0))
//                .build();
//
//        lessonsRepository.save(javaLesson1);
//        lessonsRepository.save(javaLesson2);
//        lessonsRepository.save(dbLesson1);
//        lessonsRepository.save(dbLesson2);
//
//        Comment comment1 = Comment.builder()
//                .user(student1)
//                .text("Отличный студент!")
//                .build();
//
//        Comment comment2 = Comment.builder()
//                .user(student2)
//                .text("Есть проблемы с пониманием")
//                .build();
//
//        Comment comment3 = Comment.builder()
//                .user(student3)
//                .text("Мне кажется, ему лучше идти во frontend")
//                .build();
//
//        Comment comment4 = Comment.builder()
//                .user(teacher1)
//                .text("Лучший преподаватель в мире!")
//                .build();
//
//        Comment comment5 = Comment.builder()
//                .user(teacher2)
//                .text("Еще один лучший преподаватель в мире!")
//                .build();
//
//        commentsRepository.save(comment1);
//        commentsRepository.save(comment2);
//        commentsRepository.save(comment3);
//        commentsRepository.save(comment4);
//        commentsRepository.save(comment5);
    }

}
