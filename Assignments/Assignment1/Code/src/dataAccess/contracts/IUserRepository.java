package dataAccess.contracts;

import dataAccess.model.UserDto;

import java.util.List;

public interface IUserRepository {

    public List<UserDto> findAll();

    public boolean update(UserDto userDto);

    public boolean delete(UserDto userDto);

    public boolean create(UserDto userDto);

    public UserDto findById(int id);

}
