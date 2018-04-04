package dataAccess.repositories;

import businessLogic.contractsDAO.ITicketRepository;
import dataAccess.model.TicketDto;
import dataAccess.utility.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository implements ITicketRepository {

    private List<TicketDto> createObject(ResultSet resultSet){
        List <TicketDto> objects = new ArrayList<>();

        try {
            if (resultSet.next() == false) { //nothing in the table
                return null;
            }
            resultSet.previous();

            while (resultSet.next()) {
                TicketDto crObj = new TicketDto();

                crObj.setIdticket((int)resultSet.getObject("idticket"));
                crObj.setIdshow((int)resultSet.getObject("idshow"));
                crObj.setSeatNb((int)resultSet.getObject("seatNb"));
                crObj.setRowNb((int)resultSet.getObject("rowNb"));
                crObj.setOnName((String)resultSet.getObject("onName"));

                objects.add(crObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objects;
    }

    @Override
    public List<TicketDto> findAll() {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM tickets");
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
    public boolean update(TicketDto ticketDto) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try{

            statement = connection.prepareStatement(
                    "UPDATE tickets SET idshow = ?, seatNb = ?, rowNb = ?, onName = ?" +
                            " WHERE idticket = ?");

            statement.setInt(1, ticketDto.getIdshow());
            statement.setInt(2, ticketDto.getSeatNb());
            statement.setInt(3, ticketDto.getRowNb());
            statement.setString(4, ticketDto.getOnName());
            statement.setInt(5, ticketDto.getIdticket());

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
    public boolean delete(TicketDto ticketDto) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM tickets WHERE idticket = ?");
            statement.setInt(1, ticketDto.getIdticket());

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
    public boolean create(TicketDto ticketDto) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO tickets (idshow, seatNb, rowNb, onName)" +
                    " VALUES (?, ?, ?, ?)");

            statement.setInt(1, ticketDto.getIdshow());
            statement.setInt(2, ticketDto.getSeatNb());
            statement.setInt(3, ticketDto.getRowNb());
            statement.setString(4, ticketDto.getOnName());

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
    public TicketDto findById(int id) {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM tickets WHERE idticket = ?");
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
