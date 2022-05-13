package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.service.EmployeeService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class login extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        String adminUserName = config.getServletContext().getInitParameter("adminUserName");
        String adminPass = config.getServletContext().getInitParameter("adminPass");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String empCode = req.getParameter("empCode");
            String password = req.getParameter("password");
            List<Employee> login = EmployeeService.getInstance().login(new Employee().setEmpCode(empCode).setPassword(password));
            if (!login.isEmpty()){
                req.getSession().setAttribute("empCode", empCode);
                req.getSession().setAttribute("password", password);
                resp.sendRedirect("/employee/employee.jsp");
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
        super.destroy();
    }
}
