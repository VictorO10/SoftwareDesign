package dataAccess.tests;

import dataAccess.model.UserDto;
import dataAccess.repositories.UserRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Test
    public void create() throws Exception {
        UserRepository userRepository = new UserRepository();

        int sizeBefore = userRepository.findAll().size();

        UserDto userDto = new UserDto();

        userDto.setUsername("Gigel");
        userDto.setPassword("gigel");
        userDto.setPermission("Cashier");
        userDto.setName("Gigel Armando");

        userRepository.create(userDto);

        int sizeAfter = userRepository.findAll().size();

        assert(sizeBefore + 1 == sizeAfter);
    }

}