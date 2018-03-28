package businessLogic.services;

import businessLogic.contracts.IUserMapper;
import businessLogic.contracts.IUserService;
import businessLogic.model.UserModel;
import dataAccess.contracts.IUserRepository;
import dataAccess.model.UserDto;
import dataAccess.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepository userRepository;
    private IUserMapper userMapper;

    public UserService(){
        userRepository = new UserRepository();
        userMapper = new UserMapper();
    }

    @Override
    public UserModel getById(int id) {
        return userMapper.map(userRepository.findById(id));
    }

    @Override
    public List<UserModel> getAll() {
        List <UserModel> userModelList = new ArrayList<>();

        for(UserDto uDto : userRepository.findAll()) {
                userModelList.add(userMapper.map(uDto));
        }

        return userModelList;
    }

    @Override
    public boolean create(UserModel userModel) {
        UserDto uDto = userMapper.map(userModel);

        return userRepository.create(uDto);
    }

    @Override
    public boolean update(UserModel userModel) {
        UserDto uDto = userMapper.map(userModel);

        return userRepository.update(uDto);
    }

    @Override
    public boolean delete(UserModel userModel) {
        UserDto uDto = userMapper.map(userModel);

        return userRepository.delete(uDto);
    }

    @Override
    public boolean deleteById(int userid) {

        return this.delete(this.getById(userid));
    }

    @Override
    public List<UserModel> getAllCashiers() {
        List <UserModel> userModelList = new ArrayList<>();

        for(UserDto uDto : userRepository.findAll()) {
            if(uDto.getPermission().equals("Cashier")) {
                userModelList.add(userMapper.map(uDto));
            }
        }

        return userModelList;
    }

    @Override
    public int login(String userName, String pass) {

        for (UserModel userModel: this.getAll()) {
            System.out.println(userModel);
            if(userModel.getUsername().equals(userName) && userModel.getPassword().equals(pass)) {
                if (userModel.getPermission().equals("Admin")) {
                    return 1;
                } else if (userModel.getPermission().equals("Cashier")) {
                    return 2;
                } else {
                    return 3;
                }
            }
        }

        return 0;
    }
}
