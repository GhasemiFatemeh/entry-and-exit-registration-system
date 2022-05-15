package ir.mydvp.model.repository;

import ir.mydvp.common.JDBC;
import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDA implements AutoCloseable{
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public RoleDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Role role) throws Exception{
        preparedStatement = connection.prepareStatement("insert into Role (employeeId, role) values (?,?)");
        preparedStatement.setLong(1, role.getEmployeeId());
        preparedStatement.setString(2, role.getRole());
        preparedStatement.executeUpdate();
    }

    public List<Role> selectRoleByPersonId(Employee employee) throws Exception{
        preparedStatement= connection.prepareStatement("select role from role where employeeId=?");
        preparedStatement.setLong(1, employee.getEmployeeId());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Role> roleList= new ArrayList<>();
        while (resultSet.next()){
            Role role = new Role().setRole(resultSet.getString("role"));
            roleList.add(role);
        }
        return roleList;
    }

    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();
    }
}
