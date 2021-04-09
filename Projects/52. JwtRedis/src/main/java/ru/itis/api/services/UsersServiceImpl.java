package ru.itis.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.api.models.User;
import ru.itis.api.redis.services.RedisUsersService;
import ru.itis.api.repository.UsersRepository;

/**
 * 09.04.2021
 * 52. JwtRedis
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RedisUsersService redisUsersService;

    @Override
    public void blockUser(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        redisUsersService.addAllTokensToBlackList(user);
    }
}
