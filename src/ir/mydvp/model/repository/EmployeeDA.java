package ir.mydvp.model.repository;

import ir.mydvp.common.JDBC;
import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDA implements AutoCloseable{
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public EmployeeDA() throws Exception {
        connection = JDBC.getConnection();
        preparedStatement = connection.prepareStatement("create table employee(employeeId number, name varchar2(20), family varchar2(20), empCode varchar2(20), password varchar2(20), entranceTime timeStamp, exitTime timeStamp)");
        preparedStatement.execute();
        preparedStatement.close();
    }


    public void insert(Employee employee) throws SQLException {
        preparedStatement = connection.prepareStatement("select employee_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        employee.setEmployeeId(resultSet.getLong("Id"));
        preparedStatement = connection.prepareStatement("insert into employee (employeeId,name,family, empCode, password, entranceTime, exitTime) values (?,?,?,?,?,?,?)");
        preparedStatement.setLong(1, employee.getEmployeeId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getFamily());
        preparedStatement.setString(4, employee.getEmpCode());
        preparedStatement.setString(5, employee.getPassword());
        preparedStatement.setTimestamp(6, employee.getEntranceTime());
        preparedStatement.setTimestamp(7, employee.getExitTime());
        preparedStatement.executeUpdate();
    }


    public void updateEntranceTime(Employee employee) throws SQLException {
        preparedStatement = connection.prepareStatement("update employee set entranceTime=? where employeeId=?");
        preparedStatement.setTimestamp(1, employee.getEntranceTime());
        preparedStatement.setLong(2, employee.getEmployeeId());
        preparedStatement.executeUpdate();
    }

    public void updateExitTime(Employee employee) throws SQLException {
        preparedStatement = connection.prepareStatement("update employee set exitTime=? where employeeId=?");
        preparedStatement.setTimestamp(1, employee.getExitTime());
        preparedStatement.setLong(2, employee.getEmployeeId());
        preparedStatement.executeUpdate();
    }
    public void delete(Employee employee) throws SQLException {
        preparedStatement = connection.prepareStatement("delete from employee where employeeId=?");
        preparedStatement.setLong(1, employee.getEmployeeId());
        preparedStatement.executeUpdate();
    }

    public List<Employee> selectAll() throws SQLException {
        preparedStatement = connection.prepareStatement("select * from employee");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Employee> employeeList = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getLong("employeeId"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("empCode"),
                    resultSet.getString("password"),
                    resultSet.getTimestamp("entranceTime"),
                    resultSet.getTimestamp("exitTime"));
            employeeList.add(employee);
        }
        return employeeList;
    }

    public Employee selectByEmpCodeAndPass(Employee employee) throws SQLException{
        preparedStatement= connection.prepareStatement("select * from employee where empCode=? and password=?");
        preparedStatement.setString(1, employee.getEmpCode());
        preparedStatement.setString(2, employee.getPassword());
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()){
           return  new Employee(resultSet.getLong("employeeId"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("empCode"),
                    resultSet.getString("password"),
                    resultSet.getTimestamp("entranceTime"),
                    resultSet.getTimestamp("exitTime"));
        }
        return null;
    }

    public List<Role> selectRoleOfEmployee(Employee employee) throws SQLException{
        preparedStatement = connection.prepareStatement("select role from Role where employeeId=?");
        preparedStatement.setLong(1, employee.getEmployeeId());
        ResultSet resultSet= preparedStatement.executeQuery();
        List<Role> roleList= new ArrayList<>();
        while (resultSet.next()){
            Role role = new Role().setRole(resultSet.getString("role"));
            roleList.add(role);
        }
        return roleList;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
