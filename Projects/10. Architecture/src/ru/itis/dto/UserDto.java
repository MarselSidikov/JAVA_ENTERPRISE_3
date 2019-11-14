package ru.itis.dto;

import ru.itis.models.User;

public class UserDto implements Dto {
    private Long id;
    private String login;

    // TODO: вместо конструктора Builder
    private UserDto(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getPassword());
    }
}
