package utility.providers;

import dagger.Module;
import dagger.Provides;
import dataAccess.contracts.IUserRepository;
import dataAccess.repositories.UserRepository;

@Module
public class UserRepositoryProvider {

    @Provides
    IUserRepository getIUserRepository(){
        return new UserRepository();
    }
}
