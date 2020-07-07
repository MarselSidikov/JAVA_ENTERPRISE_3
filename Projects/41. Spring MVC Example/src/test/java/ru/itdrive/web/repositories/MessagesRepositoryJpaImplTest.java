package ru.itdrive.web.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itdrive.web.config.TestApplicationConfig;
import ru.itdrive.web.models.Message;

/**
 * 23.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
class MessagesRepositoryJpaImplTest {

    private MessagesRepository messagesRepository;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        messagesRepository = context.getBean("messagesRepositoryJpaImpl", MessagesRepository.class);
    }

    @Test
    void save() {
        messagesRepository.save(Message.builder().text("Hello!").build());
        System.out.println(messagesRepository.findAll());
    }
}