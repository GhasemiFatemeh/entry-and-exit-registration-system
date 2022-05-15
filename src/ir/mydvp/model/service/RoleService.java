package ir.mydvp.model.service;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.entity.Role;
import ir.mydvp.model.repository.RoleDA;

import java.util.List;

public class RoleService {
    private RoleService(){}
    private static final RoleService roleService = new RoleService();

    public static RoleService getInstance() {
        return roleService;
    }

    public void save(Role role) throws Exception{
        try (RoleDA roleDA= new RoleDA()){
            roleDA.insert(role);
        }
    }

    public List<Role> getEmployeeRoles(Employee employee) throws Exception{
        try (RoleDA roleDA= new RoleDA()){
            long employeeId = EmployeeService.getInstance().findPerson(employee).getEmployeeId();
            employee.setEmployeeId(employeeId);
            return roleDA.selectRoleByPersonId(employee);
        }
    }
}
