import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserService_Factory implements Factory<UserService> {
  private static final UserService_Factory INSTANCE = new UserService_Factory();

  @Override
  public UserService get() {
    return new UserService();
  }

  public static Factory<UserService> create() {
    return INSTANCE;
  }
}
