package businessLogic.contracts;

import businessLogic.model.ShowModel;

import java.util.List;

public interface IShowService {

    ShowModel getById(int id);
    List<ShowModel> getAll();

    boolean create(ShowModel showModel);
    boolean update(ShowModel showModel);
    boolean delete(ShowModel showModel);
    boolean deleteById(int showid);
}
