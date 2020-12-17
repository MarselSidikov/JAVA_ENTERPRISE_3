package ru.itis.search.repositories;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;
import ru.itis.search.dto.UserDto;
import ru.itis.search.dto.UserRequest;
import ru.itis.search.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import static ru.itis.search.models.QUser.user;
/**
 * 17.12.2020
 * 50. query-dsl-demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class AccountsByRequestRepositoryImpl implements AccountsByRequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserDto> findByRequest(UserRequest userRequest) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userRequest.getFirstName() != null) {
            predicate.or(user.firstName.containsIgnoreCase(userRequest.getFirstName()));
        }
        if (userRequest.getLastName() != null) {
            predicate.or(user.lastName.containsIgnoreCase(userRequest.getLastName()));
        }
        if (userRequest.getCourseName() != null) {
            predicate.or(user.courses.any().name.containsIgnoreCase(userRequest.getCourseName()));
        }

        return new JPAQuery<User>(entityManager)
                .select(user.firstName, user.lastName)
                .from(user)
                .where(predicate)
                .fetch().stream()
                .map(row -> UserDto.builder()
                .firstName(row.get(user.firstName))
                .lastName(row.get(user.lastName))
                .build())
                .collect(Collectors.toList());

    }
}
