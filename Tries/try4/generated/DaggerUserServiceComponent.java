import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerUserServiceComponent implements UserServiceComponent {
  private UserServiceProvider userServiceProvider;

  private DaggerUserServiceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static UserServiceComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.userServiceProvider = builder.userServiceProvider;
  }

  @Override
  public void provideUserService(AppA appA) {
    injectAppA(appA);
  }

  @Override
  public void provideUserService(AppB appB) {
    injectAppB(appB);
  }

  private AppA injectAppA(AppA instance) {
    AppA_MembersInjector.injectSetUserServiceHelper(
        instance,
        Preconditions.checkNotNull(
            userServiceProvider.getUserServiceHelper(),
            "Cannot return null from a non-@Nullable @Provides method"),
        Preconditions.checkNotNull(
            userServiceProvider.getUserRepository(),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  private AppB injectAppB(AppB instance) {
    AppB_MembersInjector.injectUserServiceHelper(
        instance,
        Preconditions.checkNotNull(
            userServiceProvider.getUserServiceHelper(),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  public static final class Builder {
    private UserServiceProvider userServiceProvider;

    private Builder() {}

    public UserServiceComponent build() {
      if (userServiceProvider == null) {
        this.userServiceProvider = new UserServiceProvider();
      }
      return new DaggerUserServiceComponent(this);
    }

    public Builder userServiceProvider(UserServiceProvider userServiceProvider) {
      this.userServiceProvider = Preconditions.checkNotNull(userServiceProvider);
      return this;
    }
  }
}
