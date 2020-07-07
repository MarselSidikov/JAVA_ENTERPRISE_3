package ru.itdrive.web.repositories;

import ru.itdrive.web.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User> {
    List<User> searchByEmail(String emailPattern);
}
