import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserServiceProvider_GetUserServiceHelperFactory
    implements Factory<UserServiceHelper> {
  private final UserServiceProvider module;

  public UserServiceProvider_GetUserServiceHelperFactory(UserServiceProvider module) {
    this.module = module;
  }

  @Override
  public UserServiceHelper get() {
    return Preconditions.checkNotNull(
        module.getUserServiceHelper(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserServiceHelper> create(UserServiceProvider module) {
    return new UserServiceProvider_GetUserServiceHelperFactory(module);
  }

  public static UserServiceHelper proxyGetUserServiceHelper(UserServiceProvider instance) {
    return instance.getUserServiceHelper();
  }
}
