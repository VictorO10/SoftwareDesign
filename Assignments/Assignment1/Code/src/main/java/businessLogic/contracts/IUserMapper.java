package businessLogic.contracts;

import businessLogic.model.UserModel;
import dataAccess.model.UserDto;

public interface IUserMapper {

    UserModel map(UserDto userDto);
    UserDto map(UserModel userModel);

}
