package businessLogic.services;

import businessLogic.contracts.IUserMapper;
import businessLogic.model.UserModel;
import dataAccess.model.UserDto;

public class UserMapper implements IUserMapper{

    @Override
    public UserModel map(UserDto userDto) {
        UserModel userModel = new UserModel();

        userModel.setIduser(userDto.getIduser());
        userModel.setUsername(userDto.getUsername());
        userModel.setPassword(userDto.getPassword());
        userModel.setPermission(userDto.getPermission());
        userModel.setName(userDto.getName());

        return userModel;
    }

    @Override
    public UserDto map(UserModel userModel) {
        UserDto userDto = new UserDto();

        userDto.setIduser(userModel.getIduser());
        userDto.setUsername(userModel.getUsername());
        userDto.setPassword(userModel.getPassword());
        userDto.setPermission(userModel.getPermission());
        userDto.setName(userModel.getName());

        return userDto;
    }
    
}
