package ir.mydvp.model.repository;

import ir.mydvp.common.JDBC;
import ir.mydvp.model.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDA implements AutoCloseable{
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public RoleDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Role role) throws Exception{
        preparedStatement = connection.prepareStatement("select person_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        role.setPersonId(resultSet.getLong("roleId"));
        preparedStatement = connection.prepareStatement("insert into Role (roleId, personId, role) values (?,?,?)");
        preparedStatement.setLong(1, role.getRoleId());
        preparedStatement.setLong(2, role.getPersonId());
        preparedStatement.setString(3, role.getRole());
        preparedStatement.executeUpdate();
    }

    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();
    }
}
