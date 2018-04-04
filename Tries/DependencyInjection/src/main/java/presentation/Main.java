package presentation;

import business.IUserService;
import business.UserService;

import javax.inject.Inject;

public class Main {

    public static void main(String[] args) {

        businessCreator gui = new businessCreator();

        gui.run();
    }



}
