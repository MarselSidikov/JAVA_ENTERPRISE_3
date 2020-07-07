package ru.itdrive.web.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itdrive.web.config.TestApplicationConfig;
import ru.itdrive.web.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 09.06.2020
 * 40. AjaxSearchExample
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
class UsersRepositoryJdbcTemplateImplTest {

    UsersRepositoryJdbcTemplateImpl usersRepository;

    private static final User USER = User.builder()
            .id(1L)
            .email("USER")
            .confirmCode("0a4d8114-5b6c-4929-b72c-9f1a7d05293d")
            .password("USER")
            .build();

    private static final int USERS_COUNT = 3;
    private static final Long NEW_USER_ID = 4L;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
    }

    @Test
    void searchByEmail() {
        List<User> actual = usersRepository.searchByEmail("ER");
        User actualUser = actual.get(0);
        assertEquals(USER, actualUser);
    }

    @Test
    void findAll() {
        List<User> actual = usersRepository.findAll();
        assertEquals(actual.size(), USERS_COUNT);
    }

    @Test
    void findOnCorrectId() {
        Optional<User> actualOptional = usersRepository.find(1L);
        User actual = actualOptional.get();
        assertEquals(USER, actual);
    }

    @Test
    void findOnInCorrectId() {
        Optional<User> actualOptional = usersRepository.find(4L);
        assertFalse(actualOptional.isPresent());
    }

    @Test
    void update() {
        User userForUpdate = usersRepository.find(1L).get();
        userForUpdate.setEmail("NEW_EMAIL");
        usersRepository.update(userForUpdate);
        User userAfterUpdate = usersRepository.find(1L).get();
        assertEquals("NEW_EMAIL", userAfterUpdate.getEmail());
    }

    @Test
    void save() {
        User user = User.builder()
                .password("A")
                .email("A")
                .confirmCode("A")
                .build();
        usersRepository.save(user);
        assertEquals(NEW_USER_ID, user.getId());
    }
}