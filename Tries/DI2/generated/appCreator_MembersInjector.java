import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class appCreator_MembersInjector implements MembersInjector<appCreator> {
  private final Provider<Application> appProvider;

  public appCreator_MembersInjector(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  public static MembersInjector<appCreator> create(Provider<Application> appProvider) {
    return new appCreator_MembersInjector(appProvider);
  }

  @Override
  public void injectMembers(appCreator instance) {
    injectApp(instance, appProvider.get());
  }

  public static void injectApp(appCreator instance, Application app) {
    instance.app = app;
  }
}
