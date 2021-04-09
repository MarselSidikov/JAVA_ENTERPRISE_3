package ru.itis.api.services;


import ru.itis.api.dto.EmailPasswordDto;
import ru.itis.api.dto.TokenDto;

/**
 * 05.04.2021
 * 21. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface LoginService {
    TokenDto login(EmailPasswordDto emailPassword);
}
