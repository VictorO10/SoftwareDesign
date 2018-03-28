package presentation;

import businessLogic.contracts.IShowService;
import businessLogic.contracts.IUserService;
import businessLogic.model.ShowModel;
import businessLogic.model.UserModel;
import businessLogic.services.ShowService;
import businessLogic.services.UserService;


public class controller {
    public static void main(String[] args) {
        System.out.println("Hello! Victor's Project");

        GUI gui = new GUI();

    /*    IUserService userService = new UserService();

        for (UserModel u : userService.getAllCashiers()) {
            System.out.println(u);
        }

        IShowService showService = new ShowService();

        for (ShowModel s : showService.getAllCashiers()) {
            System.out.println(s);
        }

        UserModel userModel = userService.getById(4);
        userModel.setUsername("Profesor");
        userService.create(userModel);

        ShowModel showModel = showService.getById(2);
        showModel.setTitle("DESPRE VIATA SI ALTE LUCRURI");
        System.out.println(showModel.getDistribution());
        showService.update(showModel);*/
    }
}
