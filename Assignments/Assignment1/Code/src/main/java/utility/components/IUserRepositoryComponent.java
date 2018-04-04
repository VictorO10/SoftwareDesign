package utility.components;

import businessLogic.services.UserService;
import dagger.Component;
import utility.providers.UserRepositoryProvider;

@Component(modules = {UserRepositoryProvider.class})
public interface IUserRepositoryComponent {

    void provideUserRepository(UserService userService);
}
