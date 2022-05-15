package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setName(req.getParameter("name")).setFamily(req.getParameter("family")).setEmpCode(req.getParameter("empCode")).setPassword(req.getParameter("password"));
        try {
            EmployeeService.getInstance().save(employee);
            resp.sendRedirect("/login.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
