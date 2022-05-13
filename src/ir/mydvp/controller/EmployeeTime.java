package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee")
public class EmployeeTime extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empCode = (String) req.getSession().getAttribute("empCode");
        String password = (String) req.getSession().getAttribute("password");
        String entranceTime = req.getParameter("entranceTime");
        try {
            EmployeeService.getInstance().setEntranceTime(new Employee().setEmpCode(empCode).setPassword(password).setEntranceTime(entranceTime));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
