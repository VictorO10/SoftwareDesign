package utility.providers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dataAccess.contracts.IUserRepository;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserRepositoryProvider_GetIUserRepositoryFactory
    implements Factory<IUserRepository> {
  private final UserRepositoryProvider module;

  public UserRepositoryProvider_GetIUserRepositoryFactory(UserRepositoryProvider module) {
    this.module = module;
  }

  @Override
  public IUserRepository get() {
    return Preconditions.checkNotNull(
        module.getIUserRepository(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IUserRepository> create(UserRepositoryProvider module) {
    return new UserRepositoryProvider_GetIUserRepositoryFactory(module);
  }

  public static IUserRepository proxyGetIUserRepository(UserRepositoryProvider instance) {
    return instance.getIUserRepository();
  }
}
