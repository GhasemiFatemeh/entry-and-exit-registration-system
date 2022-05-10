package ir.mydvp.model.service;

import ir.mydvp.model.entity.Role;
import ir.mydvp.model.repository.RoleDA;

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
}
