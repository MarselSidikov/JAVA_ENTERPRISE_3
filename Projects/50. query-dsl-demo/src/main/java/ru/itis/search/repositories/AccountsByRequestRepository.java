package ru.itis.search.repositories;

import ru.itis.search.dto.UserDto;
import ru.itis.search.dto.UserRequest;

import java.util.List;

/**
 * 17.12.2020
 * 50. query-dsl-demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsByRequestRepository {
    List<UserDto> findByRequest(UserRequest userRequest);
}
