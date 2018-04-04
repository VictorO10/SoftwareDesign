package businessLogic.contracts;

import businessLogic.model.TicketModel;

import java.util.List;

public interface ITicketService {

    public TicketModel getById(int id);
    public List<TicketModel> getAll();

    public int create(TicketModel ticketModel);
    public int update(TicketModel ticketModel);
    public boolean delete(TicketModel ticketModel);
    public boolean deleteById(int idticket);

    public List<TicketModel> getAllByShowid(int idshow);
}
