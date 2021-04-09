package ru.itis.api.redis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.api.repository.BlacklistRepository;

/**
 * 09.04.2021
 * 52. JwtRedis
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class BlacklistRepositoryRedisTemplateImpl implements BlacklistRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String token) {
        redisTemplate.opsForValue().set(token, "");
    }

    @Override
    public boolean exists(String token) {
        Boolean hasToken = redisTemplate.hasKey(token);
        return hasToken != null && hasToken;
    }
}
