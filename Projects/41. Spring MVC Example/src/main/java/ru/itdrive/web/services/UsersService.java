package ru.itdrive.web.services;

import ru.itdrive.web.models.User;

import java.util.List;

/**
 * 11.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    List<User> getAllUsers();
    void addUser(User user);
}
