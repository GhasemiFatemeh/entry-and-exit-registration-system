package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/employee/exitTime.do")
public class ExitTimeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empCode = (String) req.getSession().getAttribute("empCode");
        String password = (String) req.getSession().getAttribute("password");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            EmployeeService.getInstance().setExitTime(new Employee().setEmpCode(empCode).setPassword(password).setExitTime(new Timestamp(currentTimeMillis)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
