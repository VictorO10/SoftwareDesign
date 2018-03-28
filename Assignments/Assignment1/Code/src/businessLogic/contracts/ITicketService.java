package businessLogic.contracts;

import businessLogic.model.TicketModel;

import java.util.List;

public interface ITicketService {

    TicketModel getById(int id);
    List<TicketModel> getAll();

    boolean create(TicketModel ticketModel);
    boolean update(TicketModel ticketModel);
    boolean delete(TicketModel ticketModel);
    boolean deleteById(int idticket);

    List<TicketModel> getAllByShowid(int idshow);
}
