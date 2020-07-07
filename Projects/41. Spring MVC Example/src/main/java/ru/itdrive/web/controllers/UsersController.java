package ru.itdrive.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itdrive.web.models.User;
import ru.itdrive.web.services.UsersService;

import java.util.List;

/**
 * 15.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "usersPage";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(User user) {
        usersService.addUser(user);
        return "redirect:/users";
    }
}
