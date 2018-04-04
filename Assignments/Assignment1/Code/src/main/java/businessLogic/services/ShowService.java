package businessLogic.services;

import businessLogic.contracts.IShowMapper;
import businessLogic.contracts.IShowService;
import businessLogic.model.ShowModel;
import utility.components.DaggerIShowRepositoryComponent;
import utility.components.IShowRepositoryComponent;
import businessLogic.contractsDAO.IShowRepository;
import dataAccess.model.ShowDto;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ShowService implements IShowService{

    private IShowRepository showRepository;
    private IShowMapper showMapper;

    public ShowService(){
        IShowRepositoryComponent showRepositoryComponent = DaggerIShowRepositoryComponent.builder().build();
        showRepositoryComponent.provideShowRepository(this);
        showMapper = new ShowMapper();
    }

    @Override
    public ShowModel getById(int id) {
        return showMapper.map(showRepository.findById(id));
    }

    @Override
    public List<ShowModel> getAll() {
        List <ShowModel> showModelList = new ArrayList<>();

        for(ShowDto uDto : showRepository.findAll()) {
            showModelList.add(showMapper.map(uDto));
        }

        return showModelList;
    }

    @Override
    public boolean create(ShowModel showModel) {
        ShowDto uDto = showMapper.map(showModel);

        return showRepository.create(uDto);

    }

    @Override
    public boolean update(ShowModel showModel) {
        ShowDto uDto = showMapper.map(showModel);

        return showRepository.update(uDto);
    }

    @Override
    public boolean delete(ShowModel showModel) {
        ShowDto uDto = showMapper.map(showModel);

        return showRepository.delete(uDto);
    }

    @Override
    public boolean deleteById(int showid) {

        return this.delete(this.getById(showid));
    }

    @Override
    public void ticketSold(int idshow) {
        ShowModel showModel = this.getById(idshow);

        int soldTickets = showModel.getSoldTickets();
        soldTickets++;
        showModel.setSoldTickets(soldTickets);

        this.update(showModel);
    }

    @Override
    public void ticketCanceled(int idshow) {
        ShowModel showModel = this.getById(idshow);

        int soldTickets = showModel.getSoldTickets();
        soldTickets--;
        showModel.setSoldTickets(soldTickets);

        this.update(showModel);
    }

    @Inject
    public void setIShowRepository(IShowRepository showRepository){
        this.showRepository = showRepository;
    }
}
