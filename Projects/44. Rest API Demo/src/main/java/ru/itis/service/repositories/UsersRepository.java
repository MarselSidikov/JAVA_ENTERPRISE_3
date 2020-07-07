package ru.itis.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.service.models.User;

import java.util.Optional;

/**
 * 03.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select user FROM User user JOIN user.tokens token WHERE token = ?1")
    Optional<User> findByToken(String token);
}
