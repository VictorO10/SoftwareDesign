import javax.inject.Inject;

public class AppB {

    @Inject
    UserServiceHelper userServiceHelper;

    public void doAppStuff() {
        UserService userService = userServiceHelper.getUserService(new UserRepository());
        System.out.print("appB ");
        userService.doStuff();
    }
}
