package ru.itis.services;

import ru.itis.dto.UserDto;

public interface SignInService {
    UserDto signIn(String login, String password);
}
