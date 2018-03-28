package businessLogic.tests;

import businessLogic.model.UserModel;
import businessLogic.services.UserService;
import org.junit.Test;


public class UserServiceTest {

    @Test
    public void create() throws Exception {
        UserService userService = new UserService();

        int sizeBefore = userService.getAll().size();

        UserModel userModel = new UserModel();

        userModel.setUsername("Gigel");
        userModel.setPassword("gigel");
        userModel.setPermission("Cashier");
        userModel.setName("Gigel Armando");

        userService.create(userModel);

        int sizeAfter = userService.getAll().size();

        assert(sizeBefore + 1 == sizeAfter);
    }

}