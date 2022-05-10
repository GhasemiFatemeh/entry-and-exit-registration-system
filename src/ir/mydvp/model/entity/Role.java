package ir.mydvp.model.entity;

public class Role {
    private long roleId;
    private long personId;
    private String role;

    public long getRoleId() {
        return roleId;
    }

    public long getPersonId() {
        return personId;
    }

    public Role setPersonId(long personId) {
        this.personId = personId;
        return this;
    }

    public Role setRoleId(long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Role setRole(String role) {
        this.role = role;
        return this;
    }


}
