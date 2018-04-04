import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppB_MembersInjector implements MembersInjector<AppB> {
  private final Provider<UserServiceHelper> userServiceHelperProvider;

  public AppB_MembersInjector(Provider<UserServiceHelper> userServiceHelperProvider) {
    this.userServiceHelperProvider = userServiceHelperProvider;
  }

  public static MembersInjector<AppB> create(
      Provider<UserServiceHelper> userServiceHelperProvider) {
    return new AppB_MembersInjector(userServiceHelperProvider);
  }

  @Override
  public void injectMembers(AppB instance) {
    injectUserServiceHelper(instance, userServiceHelperProvider.get());
  }

  public static void injectUserServiceHelper(AppB instance, UserServiceHelper userServiceHelper) {
    instance.userServiceHelper = userServiceHelper;
  }
}
