package ru.itdrive.web.services;

import ru.itdrive.web.models.User;

import java.util.List;

/**
 * 08.06.2020
 * 40. WebAppExample
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersSearchService {
    List<User> searchByEmail(String emailPattern);
}
