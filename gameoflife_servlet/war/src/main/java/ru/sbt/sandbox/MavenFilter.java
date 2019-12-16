package ru.sbt.sandbox;

import javax.servlet.*;
import java.io.IOException;

public class MavenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        String name = servletRequest.getParameter("userName");
        if ("Федя".equalsIgnoreCase(name)) {
            servletResponse.getWriter().write("Ну и дура!");
            System.out.println("Filtered");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}