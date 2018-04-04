package dataAccess.repositories;

import businessLogic.contractsDAO.IUserRepository;
import dataAccess.model.UserDto;
import dataAccess.utility.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {


    private List<UserDto> createObject(ResultSet resultSet){
        List <UserDto> objects = new ArrayList<>();

        try {
            if (resultSet.next() == false) { //nothing in the table
                return null;
            }
            resultSet.previous();

            while (resultSet.next()) {
                UserDto crObj = new UserDto();

                crObj.setIduser((int)resultSet.getObject("iduser"));
                crObj.setUsername((String)resultSet.getObject("username"));
                crObj.setPassword((String)resultSet.getObject("password"));
                crObj.setPermission((String)resultSet.getObject("permission"));
                crObj.setName((String)resultSet.getObject("name"));

                objects.add(crObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objects;
    }

    @Override
    public List<UserDto> findAll() {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM users");
            resultSet = statement.executeQuery();

            return createObject(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(connection);
        }

        return null;
    }

    @Override
    public boolean update(UserDto userDto) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try{

            statement = connection.prepareStatement(
                    "UPDATE users SET username = ?, password = ?, permission = ?, name = ?" +
                            " WHERE iduser = ?");

            statement.setString(1, userDto.getUsername());
            statement.setString(2, userDto.getPassword());
            statement.setString(3, userDto.getPermission());
            statement.setString(4, userDto.getName());
            statement.setInt(5, userDto.getIduser());

            System.out.println(statement.toString());

            statement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return false;
    }

    @Override
    public boolean delete(UserDto userDto) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM users WHERE iduser = ?");
            statement.setInt(1, userDto.getIduser());

            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return false;
    }

    @Override
    public boolean create(UserDto userDto) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO users (username, password, permission, name)" +
                    " VALUES (?, ?, ?, ?)");

            statement.setString(1, userDto.getUsername());
            statement.setString(2, userDto.getPassword());
            statement.setString(3, userDto.getPermission());
            statement.setString(4, userDto.getName());

            statement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return false;
    }

    @Override
    public UserDto findById(int id) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM users WHERE iduser = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObject(resultSet).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(connection);
        }

        return null;

    }
}
