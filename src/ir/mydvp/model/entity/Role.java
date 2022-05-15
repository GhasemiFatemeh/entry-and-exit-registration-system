package ir.mydvp.model.entity;

public class Role {
    private long employeeId;
    private String role;


    public long getEmployeeId() {
        return employeeId;
    }

    public Role setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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
