package ru.itdrive.web.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import ru.itdrive.web.config.TestApplicationConfig;
import ru.itdrive.web.models.Room;
import ru.itdrive.web.models.User;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 24.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

class RoomsRepositoryTest {

    private RoomsRepository roomsRepository;
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        roomsRepository = context.getBean(RoomsRepository.class);
        DataSource dataSource = context.getBean("testDataSourceForJpa", DataSource.class);
        usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
    }

    @Test
    @Transactional
    void save() {
        roomsRepository.save(Room.builder()
                .name("Simple Room")
                .build());
        System.out.println(roomsRepository.findAll());
    }

    @Test
    void findAllByNameAndCreatorEmail() {
        User creator1 = User.builder()
                .email("sm@gmail.com")
                .build();
        User creator2 = User.builder()
                .email("test@gmail.com")
                .build();
        usersRepository.save(creator1);
        usersRepository.save(creator2);

        Room room1 = Room.builder()
                .name("Simple Room")
                .creator(creator1)
                .build();

        Room room2 = Room.builder()
                .name("Not Simple Rom")
                .creator(creator2)
                .build();

        roomsRepository.save(room1);
        roomsRepository.save(room2);

        List<Room> actual = roomsRepository.findAllByNameAndCreator_Email("Simple Room", "sm@gmail.com");
        System.out.println(actual);
    }
}