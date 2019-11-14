package ru.itis.services;

import ru.itis.context.Component;
import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;

import static ru.itis.dto.UserDto.from;

public class SignInServiceImpl implements SignInService, Component {

    private UsersRepository usersRepository;

    public SignInServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDto signIn(String login, String password) {
      Optional<User> userCandidate = usersRepository.findByLogin(login);
      if (userCandidate.isPresent()) {
          User user = userCandidate.get();
          if (user.getPassword().equals(password)) {
              return from(user);
          }
          // сервис не должен думать, как уйдет ответ пользователю
          // с точки зрения бизнес-лоники неправильный логин-пароль это исключение
      } throw new IllegalArgumentException();
    }

    @Override
    public String getName() {
        return "signInService";
    }
}
