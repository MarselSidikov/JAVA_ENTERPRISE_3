package ru.itis.search.controllers;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.search.dto.UserDto;
import ru.itis.search.dto.UserRequest;
import ru.itis.search.models.Course;
import ru.itis.search.models.User;
import ru.itis.search.repositories.AccountsByRequestRepository;
import ru.itis.search.repositories.AccountsRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * 17.12.2020
 * 50. query-dsl-demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class SearchController {

//    @Autowired
//    private AccountsByRequestRepository accountsByRequestRepository;
//
//
//    @GetMapping("/accounts/search")
//    public ResponseEntity<List<UserDto>> searchByRequest(UserRequest userRequest) {
//        return ResponseEntity.ok(accountsByRequestRepository.findByRequest(userRequest));
//    }

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/accounts/search")
    public ResponseEntity<List<UserDto>> searchByPredicate(@QuerydslPredicate(root = User.class, bindings = AccountsRepository.class) Predicate predicate) {
        return ResponseEntity.ok(
                StreamSupport.stream(accountsRepository.findAll(predicate).spliterator(), true)
                        .map(user ->
                                UserDto.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .courseNames(user.getCourses().stream().map(Course::getName).collect(Collectors.toList()))
                        .build()).collect(Collectors.toList()));
    }
}
