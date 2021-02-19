package ru.itis.hateoas.hateoasservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.hateoasservice.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
