package businessLogic.services;

import businessLogic.contracts.IShowMapper;
import businessLogic.model.ShowModel;
import dataAccess.model.ShowDto;

public class ShowMapper implements IShowMapper {

    @Override
    public ShowModel map(ShowDto showDto) {
        ShowModel showModel = new ShowModel();

        showModel.setIdshow(showDto.getIdshow());
        showModel.setTitle(showDto.getTitle());
        showModel.setGenre(showDto.getGenre());
        showModel.setDistribution(showDto.getDistribution());
        showModel.setDate(showDto.getDate());
        showModel.setTotalTickets(showDto.getTotalTickets());
        showModel.setSoldTickets(showDto.getSoldTickets());

        return showModel;
    }

    @Override
    public ShowDto map(ShowModel showModel) {
        ShowDto showDto = new ShowDto();

        showDto.setIdshow(showModel.getIdshow());
        showDto.setTitle(showModel.getTitle());
        showDto.setGenre(showModel.getGenre());
        showDto.setDistribution(showModel.getDistribution());
        showDto.setDate(showModel.getDate());
        showDto.setTotalTickets(showModel.getTotalTickets());
        showDto.setSoldTickets(showModel.getSoldTickets());

        return showDto;
    }
}
