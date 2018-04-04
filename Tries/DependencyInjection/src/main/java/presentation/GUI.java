package presentation;

import business.IUserService;

import javax.inject.Inject;

public class GUI {

    IUserService userService;

    @Inject
    public GUI(IUserService userService) {
        this.userService = userService;
    }

    public void doStuff() {
        System.out.println(userService.findUserById(4));
    }

}
