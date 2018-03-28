package businessLogic.contracts;

import businessLogic.model.TicketModel;
import dataAccess.model.TicketDto;

public interface ITicketMapper {

    TicketModel map(TicketDto ticketDto);
    TicketDto map(TicketModel ticketModel);

}
