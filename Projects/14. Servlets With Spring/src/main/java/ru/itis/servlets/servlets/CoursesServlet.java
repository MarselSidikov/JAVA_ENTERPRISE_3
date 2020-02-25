package ru.itis.servlets.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.servlets.models.Course;
import ru.itis.servlets.services.CoursesService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/courses")
public class CoursesServlet extends HttpServlet {

    private CoursesService coursesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        coursesService = springContext.getBean(CoursesService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = coursesService.getAllCourses();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("WEB-INF/jsp/courses.jsp").forward(request, response);
    }
}
