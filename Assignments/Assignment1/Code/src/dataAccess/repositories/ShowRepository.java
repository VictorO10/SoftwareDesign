package dataAccess.repositories;

import dataAccess.contracts.IShowRepository;
import dataAccess.model.ShowDto;
import dataAccess.utility.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowRepository implements IShowRepository{

    private List<ShowDto> createObject(ResultSet resultSet){
        List <ShowDto> objects = new ArrayList<>();

        try {
            if (resultSet.next() == false) { //nothing in the table
                return null;
            }
            resultSet.previous();

            while (resultSet.next()) {
                ShowDto crObj = new ShowDto();

                crObj.setIdshow((int)resultSet.getObject("idshow"));
                crObj.setTitle((String)resultSet.getObject("title"));
                crObj.setGenre((String)resultSet.getObject("genre"));
                crObj.setDistribution((String)resultSet.getObject("distribution"));
                crObj.setDate((Date)resultSet.getObject("date"));
                crObj.setTotalTickets((int)resultSet.getObject("totalTickets"));
                crObj.setSoldTickets((int)resultSet.getObject("soldTickets"));

                objects.add(crObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objects;
    }

    @Override
    public List<ShowDto> findAll() {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM shows");
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
    public boolean update(ShowDto showDto) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try{

            statement = connection.prepareStatement(
                    "UPDATE shows SET title = ?, genre = ?, distribution = ?, date = ?, totalTickets = ?, soldTickets = ?" +
                            " WHERE idshow = ?");

            //prepare the Date in mysql format
            Object dateSql = new java.sql.Timestamp(showDto.getDate().getTime());

            statement.setString(1, showDto.getTitle());
            statement.setString(2, showDto.getGenre());
            statement.setString(3, showDto.getDistribution());
            statement.setObject(4, dateSql); //prone to errors
            statement.setInt(5, showDto.getTotalTickets());
            statement.setInt(6, showDto.getSoldTickets());
            statement.setInt(7, showDto.getIdshow());

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
    public boolean delete(ShowDto showDto) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM shows WHERE idshow = ?");
            statement.setInt(1, showDto.getIdshow());

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
    public boolean create(ShowDto showDto) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO shows (title, genre, distribution, date, totalTickets, soldTickets)" +
                    " VALUES (?, ?, ?, ?, ?, ?)");

            //prepare the Date in mysql format
            Object dateSql = new java.sql.Timestamp(showDto.getDate().getTime());

            statement.setString(1, showDto.getTitle());
            statement.setString(2, showDto.getGenre());
            statement.setString(3, showDto.getDistribution());
            statement.setObject(4, dateSql); //prone to errors
            statement.setInt(5, showDto.getTotalTickets());
            statement.setInt(6, showDto.getSoldTickets());

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
    public ShowDto findById(int id) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM shows WHERE idshow = ?");
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
