package ru.itdrive.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 15.06.2020
 * 41. Spring MVC Example
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    // SpringContext(ApplicationConfig) -> AnnotationConfigWebApplicationContext -> ServletContext
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // контекст SpringWeb
        AnnotationConfigWebApplicationContext springWebContext = new AnnotationConfigWebApplicationContext();
        // регистрируем контекст с нашими бинами в контексте SpringWeb
        springWebContext.register(ApplicationConfig.class);
        // кладем SpringWeb в servletContext
        servletContext.addListener(new ContextLoaderListener(springWebContext));

        // замена регистрации сервлета в web.xml
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(springWebContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }
}
