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

@WebServlet("/init")
public class Common extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        String adminUserName = config.getServletContext().getInitParameter("adminUserName");
        String adminPass = config.getServletContext().getInitParameter("adminPass");
        try {
            EmployeeService.getInstance().save(new Employee()
                    .setEmpCode(adminUserName)
                    .setPassword(adminPass));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
