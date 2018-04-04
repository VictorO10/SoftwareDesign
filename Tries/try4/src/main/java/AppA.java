import javax.inject.Inject;

public class AppA {

    private UserServiceHelper userServiceHelper;
    private UserRepository userRepository;

    public AppA() {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.provideUserService(this);
    }

    public void doAppStuff() {
        UserService userService = userServiceHelper.getUserService(userRepository);
        System.out.print("appA ");
        userService.doStuff();
    }

    @Inject
    public void setUserServiceHelper(UserServiceHelper userServiceHelper, UserRepository userRepository){
        this.userServiceHelper = userServiceHelper;
        this.userRepository = userRepository;
    }

}
