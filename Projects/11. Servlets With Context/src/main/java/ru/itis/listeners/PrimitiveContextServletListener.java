package ru.itis.listeners;

import ru.itis.context.PrimitiveContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PrimitiveContextServletListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("IN LISTENER");
        ServletContext servletContext = servletContextEvent.getServletContext();
        PrimitiveContext primitiveContext = new PrimitiveContext();
        servletContext.setAttribute("componentsContext", primitiveContext);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
