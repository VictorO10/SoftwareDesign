import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppA_MembersInjector implements MembersInjector<AppA> {
  private final Provider<UserServiceHelper> userServiceHelperProvider;

  private final Provider<UserRepository> userRepositoryProvider;

  public AppA_MembersInjector(
      Provider<UserServiceHelper> userServiceHelperProvider,
      Provider<UserRepository> userRepositoryProvider) {
    this.userServiceHelperProvider = userServiceHelperProvider;
    this.userRepositoryProvider = userRepositoryProvider;
  }

  public static MembersInjector<AppA> create(
      Provider<UserServiceHelper> userServiceHelperProvider,
      Provider<UserRepository> userRepositoryProvider) {
    return new AppA_MembersInjector(userServiceHelperProvider, userRepositoryProvider);
  }

  @Override
  public void injectMembers(AppA instance) {
    injectSetUserServiceHelper(
        instance, userServiceHelperProvider.get(), userRepositoryProvider.get());
  }

  public static void injectSetUserServiceHelper(
      AppA instance, UserServiceHelper userServiceHelper, UserRepository userRepository) {
    instance.setUserServiceHelper(userServiceHelper, userRepository);
  }
}
