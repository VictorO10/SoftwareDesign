package businessLogic.services;

import businessLogic.contracts.ITicketMapper;
import businessLogic.model.TicketModel;
import dataAccess.model.TicketDto;

public class TicketMapper implements ITicketMapper {


    @Override
    public TicketModel map(TicketDto ticketDto) {
        TicketModel ticketModel = new TicketModel();

        ticketModel.setIdticket(ticketDto.getIdticket());
        ticketModel.setIdshow(ticketDto.getIdshow());
        ticketModel.setSeatNb(ticketDto.getSeatNb());
        ticketModel.setRowNb(ticketDto.getRowNb());
        ticketModel.setOnName(ticketDto.getOnName());

        return ticketModel;
    }

    @Override
    public TicketDto map(TicketModel ticketModel) {
        TicketDto ticketDto = new TicketDto();

        ticketDto.setIdticket(ticketModel.getIdticket());
        ticketDto.setIdshow(ticketModel.getIdshow());
        ticketDto.setSeatNb(ticketModel.getSeatNb());
        ticketDto.setRowNb(ticketModel.getRowNb());
        ticketDto.setOnName(ticketModel.getOnName());

        return ticketDto;
    }
}
