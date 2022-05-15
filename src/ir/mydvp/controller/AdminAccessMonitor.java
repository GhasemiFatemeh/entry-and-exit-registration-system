package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.entity.Role;
import ir.mydvp.model.service.RoleService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/admin")
public class AdminAccessMonitor implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String empCode = (String) request.getSession().getAttribute("empCode");
        String password = (String) request.getSession().getAttribute("password");
        Employee employee = new Employee().setEmpCode(empCode).setPassword(password);
        try {
            List<Role> employeeRoles = RoleService.getInstance().getEmployeeRoles(employee);
            for (Role employeeRole : employeeRoles) {
                if (employeeRole.getRole().equals("admin")){
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
            response.sendError(403);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
