import javax.inject.Inject;

public class UserServiceHelper {

    public UserService getUserService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}
