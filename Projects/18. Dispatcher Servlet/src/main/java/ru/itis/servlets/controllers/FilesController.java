package ru.itis.servlets.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilesController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            // TODO: вернуть файл по его имени, имя как параметр запроса
        } else if (request.getMethod().equals("POST")) {
            // TODO: сохранить файл на диске
        } else {

        }
        return null;
    }
}
