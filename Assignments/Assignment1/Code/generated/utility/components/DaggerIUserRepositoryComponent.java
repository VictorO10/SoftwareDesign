package utility.components;

import businessLogic.services.UserService;
import businessLogic.services.UserService_MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import utility.providers.UserRepositoryProvider;
import utility.providers.UserRepositoryProvider_GetIUserRepositoryFactory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerIUserRepositoryComponent implements IUserRepositoryComponent {
  private UserRepositoryProvider userRepositoryProvider;

  private DaggerIUserRepositoryComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static IUserRepositoryComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.userRepositoryProvider = builder.userRepositoryProvider;
  }

  @Override
  public void provideUserRepository(UserService userService) {
    injectUserService(userService);
  }

  private UserService injectUserService(UserService instance) {
    UserService_MembersInjector.injectSetIUserRepository(
        instance,
        Preconditions.checkNotNull(
            UserRepositoryProvider_GetIUserRepositoryFactory.proxyGetIUserRepository(
                userRepositoryProvider),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  public static final class Builder {
    private UserRepositoryProvider userRepositoryProvider;

    private Builder() {}

    public IUserRepositoryComponent build() {
      if (userRepositoryProvider == null) {
        this.userRepositoryProvider = new UserRepositoryProvider();
      }
      return new DaggerIUserRepositoryComponent(this);
    }

    public Builder userRepositoryProvider(UserRepositoryProvider userRepositoryProvider) {
      this.userRepositoryProvider = Preconditions.checkNotNull(userRepositoryProvider);
      return this;
    }
  }
}
