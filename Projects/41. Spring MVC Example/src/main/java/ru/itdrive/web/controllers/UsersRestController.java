package ru.itdrive.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itdrive.web.models.User;
import ru.itdrive.web.services.UsersSearchService;
import ru.itdrive.web.services.UsersService;

import java.util.List;

/**
 * 17.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class UsersRestController {

    @Autowired
    private UsersSearchService usersSearchService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> searchUser(@RequestParam("email") String emailPattern) {
        return usersSearchService.searchByEmail(emailPattern);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> addUser(@RequestBody User user) {
        usersService.addUser(user);
        return usersService.getAllUsers();
    }
}
