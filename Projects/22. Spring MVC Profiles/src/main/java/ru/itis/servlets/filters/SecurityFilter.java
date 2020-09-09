package ru.itis.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ru.itis.servlets.filters.ResponseUtil.sendForbidden;

@WebFilter("/*")
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        System.out.println("In SecurityFilter " + request.getRequestURI() + "?" + request.getQueryString());
        if (!isProtected(request.getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession(false);
            if (session != null) {
                Boolean authenticated = (Boolean) session.getAttribute("authenticated");
                if (authenticated != null && authenticated) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
            sendForbidden(request, response);
        }
    }

    private boolean isProtected(String path) {
        return !path.startsWith("/signIn") && !path.equals("/favicon.ico");
    }

    @Override
    public void destroy() {

    }
}
