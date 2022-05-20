package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login.do")
public class LoginAccessMonitor implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;
        String empCode = req.getParameter("empCode");
        String password = req.getParameter("password");
        Employee employeeWithUserAndPass = new Employee().setEmpCode(empCode).setPassword(password);
        try {
            Employee login = EmployeeService.getInstance().findPerson(employeeWithUserAndPass);
            if (login!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                resp.sendRedirect("/register.jsp");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
