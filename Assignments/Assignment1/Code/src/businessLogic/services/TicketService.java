package businessLogic.services;

import businessLogic.contracts.ITicketMapper;
import businessLogic.contracts.ITicketService;
import businessLogic.model.TicketModel;
import dataAccess.contracts.ITicketRepository;
import dataAccess.model.TicketDto;
import dataAccess.repositories.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketService implements ITicketService{

    private ITicketRepository ticketRepository;
    private ITicketMapper ticketMapper;

    public TicketService(){
        ticketRepository = new TicketRepository();
        ticketMapper = new TicketMapper();
    }

    @Override
    public TicketModel getById(int id) {
        return ticketMapper.map(ticketRepository.findById(id));
    }

    @Override
    public List<TicketModel> getAll() {
        List <TicketModel> ticketModelList = new ArrayList<>();

        for(TicketDto uDto : ticketRepository.findAll()) {
            ticketModelList.add(ticketMapper.map(uDto));
        }

        return ticketModelList;
    }

    @Override
    public boolean create(TicketModel ticketModel) {
        TicketDto uDto = ticketMapper.map(ticketModel);

        return ticketRepository.create(uDto);

    }

    @Override
    public boolean update(TicketModel ticketModel) {
        TicketDto uDto = ticketMapper.map(ticketModel);

        return ticketRepository.update(uDto);
    }

    @Override
    public boolean delete(TicketModel ticketModel) {
        TicketDto uDto = ticketMapper.map(ticketModel);

        return ticketRepository.delete(uDto);
    }

    @Override
    public boolean deleteById(int ticketid) {

        return this.delete(this.getById(ticketid));
    }

    @Override
    public List<TicketModel> getAllByShowid(int idshow) {
        List <TicketModel> ticketModelList = new ArrayList<>();

        for(TicketDto uDto : ticketRepository.findAll()) {
            if(uDto.getIdshow() == idshow) {
                ticketModelList.add(ticketMapper.map(uDto));
            }
        }

        return ticketModelList;
    }


}
