package ir.mydvp.model.entity;

public class Users {
    private long usersId;
    private long employeeId;
    private String empCode;
    private String password;

    public long getUsersId() {
        return usersId;
    }

    public Users setUsersId(long usersId) {
        this.usersId = usersId;
        return this;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public Users setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getEmpCode() {
        return empCode;
    }

    public Users setEmpCode(String empCode) {
        this.empCode = empCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }
}
