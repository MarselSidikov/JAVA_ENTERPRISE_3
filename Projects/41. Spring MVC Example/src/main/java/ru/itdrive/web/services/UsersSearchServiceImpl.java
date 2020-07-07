package ru.itdrive.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itdrive.web.models.User;
import ru.itdrive.web.repositories.UsersRepository;

import java.util.List;

/**
 * 08.06.2020
 * 40. WebAppExample
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class UsersSearchServiceImpl implements UsersSearchService {

    @Autowired
    @Qualifier("usersRepositoryJdbcTemplateImpl")
    private UsersRepository usersRepository;

    @Override
    public List<User> searchByEmail(String emailPattern) {
        return usersRepository.searchByEmail(emailPattern);
    }
}
