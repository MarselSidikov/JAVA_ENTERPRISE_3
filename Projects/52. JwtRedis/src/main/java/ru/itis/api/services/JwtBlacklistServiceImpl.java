package ru.itis.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.api.repository.BlacklistRepository;

/**
 * 09.04.2021
 * 52. JwtRedis
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class JwtBlacklistServiceImpl implements JwtBlacklistService {

    @Autowired
    private BlacklistRepository blacklistRepository;

    @Override
    public void add(String token) {
        blacklistRepository.save(token);
    }

    @Override
    public boolean exists(String token) {
        return blacklistRepository.exists(token);
    }
}
