package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.entity.Role;
import ir.mydvp.model.service.EmployeeService;
import ir.mydvp.model.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setName(req.getParameter("name")).setFamily(req.getParameter("family")).setEmpCode(req.getParameter("empCode")).setPassword(req.getParameter("password"));
        try {
            EmployeeService.getInstance().save(employee);
            long employeeId = EmployeeService.getInstance().findPerson(employee).getEmployeeId();
            RoleService.getInstance().save(new Role().setEmployeeId(employeeId).setRole("person"));
            resp.sendRedirect("/login.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
