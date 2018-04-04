import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Application_MembersInjector implements MembersInjector<Application> {
  private final Provider<Service> serviceProvider;

  public Application_MembersInjector(Provider<Service> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  public static MembersInjector<Application> create(Provider<Service> serviceProvider) {
    return new Application_MembersInjector(serviceProvider);
  }

  @Override
  public void injectMembers(Application instance) {
    injectService(instance, serviceProvider.get());
  }

  public static void injectService(Application instance, Service service) {
    instance.service = service;
  }
}
