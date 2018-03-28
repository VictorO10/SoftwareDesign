package businessLogic.services;

import businessLogic.contracts.IShowMapper;
import businessLogic.contracts.IShowService;
import businessLogic.model.ShowModel;
import dataAccess.contracts.IShowRepository;
import dataAccess.model.ShowDto;
import dataAccess.repositories.ShowRepository;

import java.util.ArrayList;
import java.util.List;

public class ShowService implements IShowService{

    IShowRepository showRepository;
    IShowMapper showMapper;

    public ShowService(){
        showRepository = new ShowRepository();
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
}
