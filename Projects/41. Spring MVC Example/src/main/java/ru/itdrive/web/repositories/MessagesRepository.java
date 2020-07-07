package ru.itdrive.web.repositories;

import org.springframework.stereotype.Repository;
import ru.itdrive.web.models.Message;
import ru.itdrive.web.models.Room;

import java.util.List;

/**
 * 23.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface MessagesRepository extends CrudRepository<Message> {
}
