package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/employee")
public class EmployeeAccessMonitor implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String empCode = (String) request.getSession().getAttribute("empCode");
        String password = (String) request.getSession().getAttribute("password");
        if (empCode!= null && password!= null){
            filterChain.doFilter(request, response);
        }
        else {
            response.sendRedirect("/login.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
