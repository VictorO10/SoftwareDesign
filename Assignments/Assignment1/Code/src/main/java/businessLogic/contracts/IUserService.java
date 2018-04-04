package businessLogic.contracts;

import businessLogic.model.UserModel;

import java.util.List;

public interface IUserService {

    UserModel getById(int id);
    List<UserModel> getAll();

    boolean create(UserModel userModel);
    boolean update(UserModel userModel);
    boolean delete(UserModel userModel);
    boolean deleteById(int userid);

    List<UserModel> getAllCashiers();
    int login(String userName, String pass);
}
