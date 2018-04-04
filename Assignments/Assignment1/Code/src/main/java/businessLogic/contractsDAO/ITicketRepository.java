package businessLogic.contractsDAO;

import dataAccess.model.TicketDto;

import java.util.List;

public interface ITicketRepository {
    
    public List<TicketDto> findAll();

    public boolean update(TicketDto ticketDto);

    public boolean delete(TicketDto ticketDto);

    public boolean create(TicketDto ticketDto);

    public TicketDto findById(int id);
}
