package utility.providers;

import dagger.Module;
import dagger.Provides;
import dataAccess.contracts.IShowRepository;
import dataAccess.repositories.ShowRepository;

@Module
public class ShowRepositoryProvider {

    @Provides
    IShowRepository getIShowRepository(){
        return new ShowRepository();
    }
}
