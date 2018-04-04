package businessLogic.contractsDAO;

import dataAccess.model.ShowDto;

import java.util.List;

public interface IShowRepository {
    
    public List<ShowDto> findAll();

    public boolean update(ShowDto showDto);

    public boolean delete(ShowDto showDto);

    public boolean create(ShowDto showDto);

    public ShowDto findById(int id);
}
