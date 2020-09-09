package ru.itis.servlets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.servlets.services.CoursesService;

@Controller
public class CoursesMvcController {

    @Autowired
    private CoursesService coursesService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getCourses() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses", coursesService.getAllCourses());
        modelAndView.setViewName("courses");
        return modelAndView;
    }
}
