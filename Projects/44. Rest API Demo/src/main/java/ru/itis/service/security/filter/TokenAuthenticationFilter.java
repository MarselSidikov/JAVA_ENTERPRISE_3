package ru.itis.service.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.service.security.authentication.TokenAuthentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 05.07.2020
 * 44. Rest API Demo
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component("tokenAuthenticationFilter")
public class TokenAuthenticationFilter extends GenericFilterBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // преобразуем запрос в HTTP
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        logger.info("IN FILTER " + servletRequest.toString());
        // получаем токен
        String token = request.getHeader("token");
        if (token != null) {
            // создаем объект аутентификации
            Authentication authentication = new TokenAuthentication(token);
            // кладем его в контекст для текущего потока
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // отправили запрос дальше
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
