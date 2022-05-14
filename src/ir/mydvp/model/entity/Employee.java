package ir.mydvp.model.entity;

import java.sql.Timestamp;

public class Employee {
    private long employeeId;
    private String name;
    private String family;
    private String empCode;
    private String password;
    private Timestamp entranceTime;
    private Timestamp exitTime;

    public Employee(long employeeId, String name, String family, String empCode, String password, Timestamp entranceTime, Timestamp exitTime) {
        this.employeeId = employeeId;
        this.name = name;
        this.family = family;
        this.empCode = empCode;
        this.password = password;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
    }

    public Employee() {
    }

    public Employee(String name, String family, String empCode, String password,  Timestamp entranceTime, Timestamp exitTime) {
        this.name = name;
        this.family = family;
        this.empCode = empCode;
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
        return empCode;
    }

    public Employee setEmpCode(String empCode) {
        this.empCode = empCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public Timestamp getEntranceTime() {
        return entranceTime;
    }

    public Employee setEntranceTime(Timestamp entranceTime) {
        this.entranceTime = entranceTime;
        return this;
    }

    public Timestamp getExitTime() {
        return exitTime;
    }

    public Employee setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
        return this;
    }
}
