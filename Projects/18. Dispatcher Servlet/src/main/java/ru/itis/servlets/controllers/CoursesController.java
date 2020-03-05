package ru.itis.servlets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.servlets.services.CoursesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class CoursesController implements Controller {

    @Autowired
    private CoursesService coursesService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("courses", coursesService.getAllCourses());
            modelAndView.setViewName("courses");
            return modelAndView;
        }
        throw new MethodNotAllowedException(HttpMethod.POST, Collections.singleton(HttpMethod.GET));
    }
}
