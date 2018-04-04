package businessLogic.services;

import dagger.MembersInjector;
import dataAccess.contracts.IUserRepository;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserService_MembersInjector implements MembersInjector<UserService> {
  private final Provider<IUserRepository> userRepositoryProvider;

  public UserService_MembersInjector(Provider<IUserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  public static MembersInjector<UserService> create(
      Provider<IUserRepository> userRepositoryProvider) {
    return new UserService_MembersInjector(userRepositoryProvider);
  }

  @Override
  public void injectMembers(UserService instance) {
    injectSetIUserRepository(instance, userRepositoryProvider.get());
  }

  public static void injectSetIUserRepository(
      UserService instance, IUserRepository userRepository) {
    instance.setIUserRepository(userRepository);
  }
}
