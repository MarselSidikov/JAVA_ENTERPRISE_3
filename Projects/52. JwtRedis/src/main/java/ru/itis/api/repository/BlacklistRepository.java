package ru.itis.api.repository;

/**
 * 09.04.2021
 * 52. JwtRedis
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface BlacklistRepository {
    void save(String token);

    boolean exists(String token);
}
