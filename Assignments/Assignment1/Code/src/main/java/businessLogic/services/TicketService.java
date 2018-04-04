package businessLogic.services;

import businessLogic.contracts.ITicketMapper;
import businessLogic.contracts.ITicketService;
import businessLogic.model.TicketModel;
import dataAccess.contracts.ITicketRepository;
import dataAccess.model.TicketDto;
import dataAccess.repositories.TicketRepository;
import utility.components.DaggerITicketRepositoryComponent;
import utility.components.ITicketRepositoryComponent;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TicketService implements ITicketService{

    private ITicketRepository ticketRepository;
    private ITicketMapper ticketMapper;

    public TicketService(){
        ITicketRepositoryComponent ticketRepositoryComponent = DaggerITicketRepositoryComponent.builder().build();
        ticketRepositoryComponent.provideTicketRepository(this);
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

    private int checkSeatTaken(TicketModel ticket){ //codes: 0 - available, 1 - not in bounds, 2 - taken

        if(ticket.getRowNb() > 100 || ticket.getSeatNb() > 100 || ticket.getRowNb() <= 0 || ticket.getSeatNb() <= 0){
            return 1;
        }

        for(TicketModel ticketModel: getAllByShowid(ticket.getIdshow())) {
            if(ticketModel.getSeatNb() == ticket.getSeatNb() && ticketModel.getRowNb() == ticket.getRowNb()) {
                return 2;
            }
        }

        return 0;
    }

    @Override
    public int create(TicketModel ticketModel) { //codes: 0 - success, 1 - over 100, 2 - taken, 3 - error inserting in db

        TicketDto uDto = ticketMapper.map(ticketModel);

        //check if seat is already taken or not
        int code = checkSeatTaken(ticketModel);

        if (code == 0) {
            if (ticketRepository.create(uDto) == true) {
                //also modify number of sold tickets
                new ShowService().ticketSold(ticketModel.getIdshow());
                return 0;
            } else { //error inserting in db
                return 3;
            }
        } else {
            return code;
        }

    }

    @Override
    public int update(TicketModel ticketModel) {//codes: 0 - success, 1 - over 100, 2 - taken, 3 - error inserting in db

        TicketDto uDto = ticketMapper.map(ticketModel);

        //check if seat is already taken or not
        int code = checkSeatTaken(ticketModel);

        if (code == 0) {
            if (ticketRepository.update(uDto) == true) {
                //also modify number of sold tickets
                return 0;
            } else { //error inserting in db
                return 3;
            }
        } else {
            return code;
        }
    }

    @Override
    public boolean delete(TicketModel ticketModel) {
        TicketDto uDto = ticketMapper.map(ticketModel);

        new ShowService().ticketCanceled(ticketModel.getIdshow());

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

    @Inject
    public void setITicketRepository(ITicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

}
