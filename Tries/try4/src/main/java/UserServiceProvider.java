import dagger.Module;
import dagger.Provides;

@Module
public class UserServiceProvider {

    @Provides
    UserServiceHelper getUserServiceHelper(){
        return new UserServiceHelper();
    }

    @Provides
    UserRepository getUserRepository(){
       return new UserRepository();
    }
}
