package utility.components;

import businessLogic.services.ShowService;
import dagger.Component;
import utility.providers.ShowRepositoryProvider;

@Component(modules = {ShowRepositoryProvider.class})
public interface IShowRepositoryComponent {

    void provideShowRepository(ShowService showService);
}
