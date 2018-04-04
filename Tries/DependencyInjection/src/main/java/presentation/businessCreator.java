package presentation;

import business.UserService;

import javax.inject.Inject;

public class businessCreator {

    @Inject UserService userService;

    public void run(){
        userService.findUserById(4);
    }
}
