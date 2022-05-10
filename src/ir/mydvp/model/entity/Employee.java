package ir.mydvp.model.entity;

import java.sql.Date;

public class Employee {
    private long employeeId;
    private String name;
    private String family;
    private String EmpCode;
    private String password;
    private Date entranceTime;
    private Date exitTime;

    public Employee(long employeeId, String name, String family, String EmpCode, String password, Date entranceTime, Date exitTime) {
        this.employeeId = employeeId;
        this.name = name;
        this.family = family;
        this.EmpCode = EmpCode;
        this.password = password;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
    }

    public Employee() {
    }

    public Employee(String name, String family, String EmpCode, String password, Date entranceTime, Date exitTime) {
        this.name = name;
        this.family = family;
        this.EmpCode = EmpCode;
        this.password = password;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Employee setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getEmpCode() {
        return EmpCode;
    }

    public Employee setEmpCode(String empCode) {
        this.EmpCode = empCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public java.sql.Date getEntranceTime() {
        return entranceTime;
    }

    public Employee setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
        return this;
    }

    public java.sql.Date getExitTime() {
        return exitTime;
    }

    public Employee setExitTime(Date exitTime) {
        this.exitTime = exitTime;
        return this;
    }
}
