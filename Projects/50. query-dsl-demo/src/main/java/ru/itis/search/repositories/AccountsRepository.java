package ru.itis.search.repositories;

import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import ru.itis.search.models.QUser;
import ru.itis.search.models.User;

/**
 * 17.12.2020
 * 50. query-dsl-demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {
    @Override
    default void customize(QuerydslBindings bindings, QUser qUser) {
        bindings.bind(qUser.courses.any().name).as("courses.name").first(
                StringExpression::containsIgnoreCase
        );
    }
}
