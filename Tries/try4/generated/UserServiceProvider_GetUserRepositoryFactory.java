import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserServiceProvider_GetUserRepositoryFactory implements Factory<UserRepository> {
  private final UserServiceProvider module;

  public UserServiceProvider_GetUserRepositoryFactory(UserServiceProvider module) {
    this.module = module;
  }

  @Override
  public UserRepository get() {
    return Preconditions.checkNotNull(
        module.getUserRepository(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserRepository> create(UserServiceProvider module) {
    return new UserServiceProvider_GetUserRepositoryFactory(module);
  }

  public static UserRepository proxyGetUserRepository(UserServiceProvider instance) {
    return instance.getUserRepository();
  }
}
