import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Application_Factory implements Factory<Application> {
  private final Provider<Service> serviceProvider;

  public Application_Factory(Provider<Service> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public Application get() {
    return new Application(serviceProvider.get());
  }

  public static Factory<Application> create(Provider<Service> serviceProvider) {
    return new Application_Factory(serviceProvider);
  }
}
