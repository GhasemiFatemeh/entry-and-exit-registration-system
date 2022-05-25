package ir.mydvp.model.service;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.repository.EmployeeDA;

import java.util.List;

public class AdminService {
    private AdminService(){}

    private static final AdminService adminService= new AdminService();

    public static AdminService getInstance() {
        return adminService;
    }

    public List<Employee> findAll() throws Exception {
        try (EmployeeDA employeeDA = new EmployeeDA()) {
            return employeeDA.selectAll();
        }
    }
}
