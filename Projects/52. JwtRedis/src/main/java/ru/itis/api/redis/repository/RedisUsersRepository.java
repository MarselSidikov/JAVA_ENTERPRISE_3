package ru.itis.api.redis.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.itis.api.redis.models.RedisUser;

/**
 * 09.04.2021
 * 52. JwtRedis
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface RedisUsersRepository extends KeyValueRepository<RedisUser, String> {
}
