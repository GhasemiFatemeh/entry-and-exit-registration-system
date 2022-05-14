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
import java.util.Enumeration;

@WebServlet("/employee")
public class EmployeeTime extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empCode = (String) req.getSession().getAttribute("empCode");
        String password = (String) req.getSession().getAttribute("password");
        try {
            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                if (parameterName.equals("entranceTime")) {
                    EmployeeService.getInstance().setEntranceTime(new Employee().setEmpCode(empCode).setPassword(password).setEntranceTime(new Timestamp(Long.parseLong(req.getParameter(parameterName)))));

                } else if (parameterName.equals("exitTime")) {
                    EmployeeService.getInstance().setExitTime(new Employee().setEmpCode(empCode).setPassword(password).setExitTime(new Timestamp(Long.parseLong(req.getParameter(parameterName)))));

                }

            }
        } catch (Exception e) {
            throw new RuntimeException();
        }


    }

}
