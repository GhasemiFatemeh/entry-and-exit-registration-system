package ir.mydvp.model.service;


import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.entity.Role;
import ir.mydvp.model.repository.EmployeeDA;

import java.sql.Date;
import java.util.List;

public class EmployeeService {
    private EmployeeService(){}
    private static final EmployeeService EMPLOYEE_SERVICE = new EmployeeService();
    public static EmployeeService getInstance() {
        return EMPLOYEE_SERVICE;
    }

    public void save(Employee employee) throws Exception{
        try(EmployeeDA employeeDA = new EmployeeDA()) {
            employeeDA.insert(employee);
            employeeDA.commit();
        }
    }

    public void remove(Employee employee) throws Exception{
        try(EmployeeDA employeeDA = new EmployeeDA()){
            employeeDA.delete(employee);
            employeeDA.commit();
        }
    }

    public List<Employee> findAll() throws Exception{
        try(EmployeeDA employeeDA = new EmployeeDA()){
           return employeeDA.selectAll();
        }
    }

    public void setEntranceTime(Employee employee)  throws Exception{
        try(EmployeeDA employeeDA =new EmployeeDA()){
            long employeeId=login(employee).get(0).getEmployeeId();
            employeeDA.update(new Employee().setEmployeeId(employeeId).setEntranceTime(employee.getEntranceTime()));
            employeeDA.commit();
        }
    }

    public void setExitTime(Employee employee) throws Exception{
        try(EmployeeDA employeeDA =new EmployeeDA()){
            long employeeId=login(employee).get(0).getEmployeeId();
            employeeDA.update(new Employee().setEmployeeId(employeeId).setExitTime(employee.getExitTime()));
            employeeDA.commit();
        }
    }

    public List<Employee> login(Employee employee) throws Exception{
        try(EmployeeDA employeeDA = new EmployeeDA()){
            return employeeDA.selectByEmpCodeAndPass(employee);
        }
    }

    public List<Role> findRoleOfEmployee(Employee employee) throws Exception{
        try(EmployeeDA employeeDA = new EmployeeDA()) {
            return employeeDA.selectRoleOfEmployee(employee);
        }
    }




}
