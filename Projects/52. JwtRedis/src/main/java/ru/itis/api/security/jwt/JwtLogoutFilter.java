package ru.itis.api.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.api.services.JwtBlacklistService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 09.04.2021
 * 52. JwtRedis
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class JwtLogoutFilter extends OncePerRequestFilter {

    @Autowired
    private JwtBlacklistService service;

    private final RequestMatcher logoutRequest = new AntPathRequestMatcher("/logout", "GET");
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (logoutRequest.matches(request)) {
            service.add(request.getHeader("Authorization"));
            SecurityContextHolder.clearContext();
            return;
        }

        filterChain.doFilter(request, httpServletResponse);
    }
}
