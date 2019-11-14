package ru.itis.repositories;

import ru.itis.context.Component;
import ru.itis.models.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryFakeImpl implements UsersRepository, Component {
    public Optional<User> findByLogin(String login) {
        return Optional.ofNullable(new User("marsel", "qwerty007"));
    }

    @Override
    public Optional<User> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @Override
    public String getName() {
        return "usersRepository";
    }
}
