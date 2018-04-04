package businessLogic.services;

import businessLogic.contractsDAO.IShowRepository;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShowService_MembersInjector implements MembersInjector<ShowService> {
  private final Provider<IShowRepository> showRepositoryProvider;

  public ShowService_MembersInjector(Provider<IShowRepository> showRepositoryProvider) {
    this.showRepositoryProvider = showRepositoryProvider;
  }

  public static MembersInjector<ShowService> create(
      Provider<IShowRepository> showRepositoryProvider) {
    return new ShowService_MembersInjector(showRepositoryProvider);
  }

  @Override
  public void injectMembers(ShowService instance) {
    injectSetIShowRepository(instance, showRepositoryProvider.get());
  }

  public static void injectSetIShowRepository(
      ShowService instance, IShowRepository showRepository) {
    instance.setIShowRepository(showRepository);
  }
}
